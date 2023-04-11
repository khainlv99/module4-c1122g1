package com.example.cart.service;

import com.example.cart.dto.ProductDTO;
import com.example.cart.dto.ProductImgUrlDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();
    List<ProductImgUrlDTO> findAllUrl();
    ProductDTO findById (int id);
}
