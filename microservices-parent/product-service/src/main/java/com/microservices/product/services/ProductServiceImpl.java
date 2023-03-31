package com.microservices.product.services;

import com.microservices.product.exceptions.NotProductsInStockException;
import com.microservices.product.exceptions.ProductSkuNotFoundException;
import com.microservices.product.exceptions.ProductUniqueIdNotFoundException;
import com.microservices.product.feignClients.CatalogFeignClient;
import com.microservices.product.feignClients.InventoryFeignClient;
import com.microservices.product.models.dtos.CatalogResponseDto;
import com.microservices.product.models.dtos.InventoryResponseDto;
import com.microservices.product.models.dtos.ProductResponseDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {
    private final CatalogFeignClient catalogFeignClient;
    private final InventoryFeignClient inventoryFeignClient;
    public ProductResponseDto getProductByUid(String uid){
        try {
            CatalogResponseDto catalogResponseDto = catalogFeignClient.getProduct(uid);

            Integer inventoryResponseAvailable = getAvailable(uid);
            if(inventoryResponseAvailable == 0) throw new NotProductsInStockException();

            return buildProductResponseDto(catalogResponseDto,inventoryResponseAvailable);

        }
        catch (FeignException ex){
            throw new ProductUniqueIdNotFoundException();
        }
    }
    public List<ProductResponseDto> getProductsBySku(String sku){
        try {
            List<CatalogResponseDto> catalogResponseDtoList = catalogFeignClient.getProductsBySku(sku);

            return catalogResponseDtoList.stream()
                    .map(resp -> buildProductResponseDto(resp, getAvailable(resp.getUniq_id())))
                    .filter(product -> product.getAvailable() != 0)
                    .toList();
        }
        catch (FeignException ex){
            throw new ProductSkuNotFoundException();
        }
    }
    private Integer getAvailable(String uniqId) {
        InventoryResponseDto inventoryResponseDto = inventoryFeignClient.inventoryResponseDto(uniqId);
        return inventoryResponseDto.getAvailable();
    }
    private ProductResponseDto buildProductResponseDto(CatalogResponseDto catalogResponseDto, Integer integerInventoryResp){
        return ProductResponseDto.builder()
                .available(integerInventoryResp)
                .list_price(catalogResponseDto.getList_price())
                .uniq_id(catalogResponseDto.getUniq_id())
                .sku(catalogResponseDto.getSku())
                .name_title(catalogResponseDto.getName_title())
                .sale_price(catalogResponseDto.getSale_price())
                .description(catalogResponseDto.getDescription())
                .build();
    }
}





