package com.microservices.product.services;

import com.microservices.product.feignClients.CatalogFeignClient;
import com.microservices.product.feignClients.InventoryFeignClient;
import com.microservices.product.models.dtos.CatalogResponseDto;
import com.microservices.product.models.dtos.InventoryResponseDto;
import com.microservices.product.models.dtos.ProductResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProductServiceTests {
    @InjectMocks
    ProductService productService;
    @Mock
    CatalogFeignClient catalogFeignClient;
    @Mock
    InventoryFeignClient inventoryFeignClient;

    private CatalogResponseDto catalogResponseDto;
    private InventoryResponseDto inventoryResponseDto;
    private ProductResponseDto productResponseDto;

    @BeforeEach
    public void setup(){
        catalogResponseDto = CatalogResponseDto.builder()
                .sku("123123")
                .description("qweqwe")
                .uniq_id("123")
                .name_title("title")
                .list_price("123")
                .sale_price("129")
                .build();

        inventoryResponseDto = InventoryResponseDto.builder()
                .uniq_id("123")
                .available(1)
                .build();

        productResponseDto = ProductResponseDto.builder()
                .sku("123123")
                .description("qweqwe")
                .uniq_id("123")
                .name_title("title")
                .list_price("123")
                .sale_price("129")
                .available(1)
                .build();
    }

    @DisplayName("should return productDto")
    @Test
    public void returnProductDtoTest(){
            when(catalogFeignClient.getProduct(catalogResponseDto.getUniq_id())).thenReturn(catalogResponseDto);
            when(inventoryFeignClient.inventoryResponseDto(inventoryResponseDto.getUniq_id())).thenReturn(inventoryResponseDto);
            assertEquals(productResponseDto,productService.getProductByUid("123"));
    }
}
