package com.example.demo.StoreProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store-product")
public class StoreProductController {

    private final StoreProductService storeProductService;
    @Autowired
    public StoreProductController(StoreProductService storeProductService) {
        this.storeProductService = storeProductService;
    }

    @PostMapping("/create")
    public StoreProductDTO create(@RequestBody StoreProductDTO storeProductDTO){
        return storeProductService.create(storeProductDTO);
    }
}
