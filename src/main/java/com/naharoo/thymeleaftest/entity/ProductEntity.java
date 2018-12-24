package com.naharoo.thymeleaftest.entity;

import com.naharoo.thymeleaftest.common.ProductType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "APP_PRODUCTS")
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String description;

    @Column
    private Integer price;

    @Column
    private ProductType productType;
}
