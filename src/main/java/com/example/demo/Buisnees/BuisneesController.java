package com.example.demo.Buisnees;

import com.example.demo.Product.ProductDTO;
import com.example.demo.Store.StoreDTO;
import com.example.demo.StoreProduct.StoreProductService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buisnees")
public class BuisneesController {

    private final StoreProductService storeProductService;

    @Autowired
    public BuisneesController(StoreProductService storeProductService) {
        this.storeProductService = storeProductService;
    }

    @GetMapping("/get-all-products/{storeId}")
    public List<ProductDTO>  getAllProductsForStore(@PathVariable Integer storeId){
        return storeProductService.getAllProductsForStore(storeId);
    }

    @GetMapping("/get-all-stores/{productId}")
    public List<StoreDTO> getAllStoresForProduct(@PathVariable Integer productId){
        return  storeProductService.getAllSoresForProduct(productId);
    }
}
