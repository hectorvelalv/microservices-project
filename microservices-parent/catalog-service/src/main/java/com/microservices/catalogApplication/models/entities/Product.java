package com.microservices.catalogApplication.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @NotNull
    private String uniq_id;

    private String sku;
    @Column(name = "name_title", length = 500)
    private String name_title;
    private String description;
    private String list_price;
    private String sale_price;

    private String category;
    @Column(name = "category_tree", length = 1000)
    private String category_tree;
    private String average_product_rating;
    //@NotNull

    private String product_url;
    @Column(name = "product_image_urls", length = 500)
    private String product_image_urls;
    @Column(name = "brand", length = 1000)
    @NotBlank
    private String brand;

}
