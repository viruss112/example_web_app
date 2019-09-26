package com.example.demo.StoreProduct;

import com.example.demo.Product.Product;
import com.example.demo.Product.ProductDTO;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Store.Store;
import com.example.demo.Store.StoreDTO;
import com.example.demo.Store.StoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StoreProductService {

    private final StoreProductRepository storeProductRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StoreProductService(StoreProductRepository storeProductRepository, ProductRepository productRepository, StoreRepository storeRepository, ModelMapper modelMapper) {
        this.storeProductRepository = storeProductRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.modelMapper = modelMapper;
    }

    public StoreProductDTO create(StoreProductDTO storeProductDTO) {


        Product product = productRepository.findById(storeProductDTO.getProductId()).orElseThrow(() -> new IllegalArgumentException(String.format("Product id=%d does not exist", storeProductDTO.getProductId())));
        Store store = storeRepository.findById(storeProductDTO.getStoreId()).orElseThrow(() -> new IllegalArgumentException(String.format("Store id=%d does not exist", storeProductDTO.getStoreId())));
        StoreProduct storeProduct = new StoreProduct(store, product);
        storeProduct.setAditionalDescription(storeProductDTO.getAditionalDescription());

        StoreProduct savedStoreProduct = storeProductRepository.save(storeProduct);
        StoreProductDTO storeProductDTO1 = new StoreProductDTO();
        modelMapper.map(savedStoreProduct, storeProductDTO1);
        return storeProductDTO1;
    }

    public List<ProductDTO> getAllProductsForStore(Integer storeId) {

        List<Product> productList = productRepository.getAllProductsOfStore(storeId);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            modelMapper.map(product, productDTO);
            productDTOList.add(productDTO);

        }

        return productDTOList;




    }

    public List<StoreDTO> getAllSoresForProduct(Integer productId) {

        List<Store> storeList = storeRepository.getAllStoresForProduct(productId);
        List<StoreDTO> storeDTOList = new ArrayList<>();
        for(Store store: storeList){
            StoreDTO storeDTO = new StoreDTO();
            modelMapper.map(store,storeDTO);
            storeDTOList.add(storeDTO);
        }
        return storeDTOList;
    }
}
