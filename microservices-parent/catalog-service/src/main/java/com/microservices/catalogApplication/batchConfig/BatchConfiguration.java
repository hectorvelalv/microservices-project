package com.microservices.catalogApplication.batchConfig;

import com.microservices.catalogApplication.models.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@EnableTransactionManagement
public class BatchConfiguration {
    @Value("${data.jcpenny}")
    //private Resource resource;
    private String inputFileName;
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);
//    @Bean
//    public FlatFileItemReader<Product> productReader() {
//        FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
//        //Resource resource = new ClassPathResource("db.csv");
//        Resource resource = new FileSystemResource(inputFileName);
//        reader.setResource(resource);
//        reader.setLineMapper(new DefaultLineMapper<Product>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames("uniq_id","sku","name_title","description","list_price","sale_price","category",
//                        "category_tree","average_product_rating","product_url","product_image_urls","brand","total_number_reviews","reviews");
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>()  {{
//                setTargetType(Product.class);
//            }});
//        }});
//        return reader;
//    }
    @Bean
    public ItemReader<Product> reader(){
        Resource resource = new ClassPathResource("db.csv");
        System.out.println(resource.getFilename());

        return  new FlatFileItemReaderBuilder<Product>().name("productItemReader")
                .resource(resource)
                .delimited()
                .names("uniq_id","sku","name_title","description","list_price","sale_price","category",
                        "category_tree","average_product_rating","product_url","product_image_urls","brand","total_number_reviews","reviews")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
                    setTargetType(Product.class);
                }})
                .build();
    }
    public ItemProcessor<Product, Product> productItemProcessor() {
        return new SkipFirstLineItemProcessor();
    }
//    @Bean
//    public ItemWriter<Product> productWriter() {
//        JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(dataSource);
//        writer.setSql("INSERT INTO products (uniq_id,sku,name_title,description,list_price,sale_price,category," +
//                "category_tree,average_product_rating,product_url,product_image_urls,brand,total_number_reviews,reviews)" +
//                " VALUES (:uniq_id, :sku, :name_title, :description, :list_price, :sale_price,category," +
//                ":category_tree, :average_product_rating, :product_url, :product_image_urls, :brand, :total_number_reviews, :reviews)");
//        writer.setItemSqlParameterSourceProvider( new BeanPropertyItemSqlParameterSourceProvider<>());
//        return writer;
//    }
    @Bean
    public JdbcBatchItemWriter<Product> writer(DataSource dataSource){
        System.out.println("coco");
        JdbcBatchItemWriter<Product> asd = new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO products (uniq_id,sku,name_title,description,list_price,sale_price,category," +
                        "category_tree,average_product_rating,product_url,product_image_urls,brand,total_number_reviews,reviews)" +
                        " VALUES (:uniq_id, :sku, :name_title, :description, :list_price, :sale_price,category," +
                        ":category_tree, :average_product_rating, :product_url, :product_image_urls, :brand, :total_number_reviews, :reviews)")
                .dataSource(dataSource)
                .assertUpdates(true)
                .build();

        return asd;
    }

    @Bean
    public Step productStep(JobRepository jobRepository,
                            PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Product> writer){
        return new StepBuilder("productStep",jobRepository)
                .<Product,Product>chunk(10,transactionManager)
                .reader(reader())
                .processor(productItemProcessor())
                .writer(writer)
                .build();
    }
    @Bean
    public Job productJob(JobRepository jobRepository, Step productStep, JobCompletionNotificationListener listener) {
        return new JobBuilder("productJob",jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(productStep)
                .end()
                .build();
    }
}