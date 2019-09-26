package com.example.demo.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = " select * from products p where p.product_id in ( select product_product_id from store_product sp where sp.store_store_id=:id) ", nativeQuery = true)
    List<Product> getAllProductsOfStore(@Param("id") Integer id);
}
