package com.naharoo.thymeleaftest.repo;

import com.naharoo.thymeleaftest.domain.Product;
import com.naharoo.thymeleaftest.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,Long> {

}
