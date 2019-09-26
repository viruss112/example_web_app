package com.example.demo.Product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product();
        modelMapper.map(productDTO, product);
        Product savedProduct = productRepository.save(product);
        ProductDTO productDTO1 = new ProductDTO();
        modelMapper.map(savedProduct, productDTO1);
        return productDTO1;

    }
}
