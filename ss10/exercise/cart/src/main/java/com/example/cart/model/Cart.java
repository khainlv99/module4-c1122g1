package com.example.cart.model;

import com.example.cart.dto.ProductDTO;
import com.example.cart.exception.QuantityLowerThanZeroException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<ProductDTO, Integer> productMap = new LinkedHashMap<>();

    public Cart() {
    }

    public Map<ProductDTO, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDTO, Integer> productMap) {
        this.productMap = productMap;
    }

    private boolean checkItemInCart (ProductDTO productDTO) {
        for (Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(productDTO.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDTO, Integer>  selectItemInCart (ProductDTO productDTO) {
        for (Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(productDTO.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct (ProductDTO productDTO) {
        if (!checkItemInCart(productDTO)) {
            productMap.put(productDTO, 1);
        } else {
            Map.Entry<ProductDTO, Integer> itemEntry = selectItemInCart(productDTO);
            Integer newQuantity = itemEntry.getValue() + 1;
            productMap.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public void removeProduct (ProductDTO productDTO) {
        if (!checkItemInCart(productDTO)) {
            productMap.put(productDTO, 1);
        } else {
            if (productMap.get(productDTO) == 0) {
                productMap.remove(productDTO);
            } else {
                Map.Entry<ProductDTO, Integer> itemEntry = selectItemInCart(productDTO);
                Integer newQuantity = itemEntry.getValue() - 1;
                productMap.replace(itemEntry.getKey(),newQuantity);
            }
        }
    }

    public Integer countProductQuantity () {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity () {
        return productMap.size();
    }

    public Float countTotalPayment () {
        float payment = 0;
        for (Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
