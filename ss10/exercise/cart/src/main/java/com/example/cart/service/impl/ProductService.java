package com.example.cart.service.impl;

import com.example.cart.dto.ProductDTO;
import com.example.cart.dto.ProductImgUrlDTO;
import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product : productList) {
            productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ProductImgUrlDTO> findAllUrl() {
        List<Product> productList = productRepository.findAll();
        List<ProductImgUrlDTO> productImgUrlDTOList = new ArrayList<>();
        ProductImgUrlDTO ProductImgUrlDTO;
        for (Product product : productList) {
            ProductImgUrlDTO = new ProductImgUrlDTO();
            BeanUtils.copyProperties(product, ProductImgUrlDTO);
            productImgUrlDTOList.add(ProductImgUrlDTO);
        }
        return productImgUrlDTOList;
    }

    @Override
    public ProductDTO findById(int id) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(productRepository.findById(id).get(), productDTO);
        return productDTO;
    }
}