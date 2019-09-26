package com.example.demo.StoreProduct;

import com.example.demo.Product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProductRepository extends CrudRepository<StoreProduct , Integer> {


}
