DROP TABLE IF EXISTS catalog.products;

CREATE TABLE catalog.products (
  uniq_id VARCHAR(255) NOT NULL,
   sku VARCHAR(255) NULL,
   name_title TEXT NULL,
   `description` VARCHAR(255) NULL,
   list_price VARCHAR(255) NULL,
   sale_price VARCHAR(255) NULL,
   category VARCHAR(255) NULL,
   category_tree TEXT NULL,
   average_product_rating VARCHAR(255) NULL,
   product_url VARCHAR(255) NULL,
   product_image_urls TEXT NULL,
   brand TEXT NULL,
   total_number_reviews TEXT NULL,
   reviews TEXT NULL,
   CONSTRAINT pk_products PRIMARY KEY (uniq_id)
);