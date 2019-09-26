package com.example.demo.Store;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

    @Query(value = " select * from stores s where s.store_id in ( select store_store_id from store_product sp where sp.product_product_id=:id)", nativeQuery = true)
    List<Store> getAllStoresForProduct(@Param("id") Integer id);
}
