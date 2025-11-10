package com.projects.EcommerceBackend.Gateways;

import com.projects.EcommerceBackend.CustomExceptions.ApiException;
import com.projects.EcommerceBackend.DTOs.ProductDTO;

import java.util.List;

public interface IProductGateway {

    List<ProductDTO> getAllProducts() throws ApiException;
    ProductDTO addProduct(ProductDTO productDTO)  throws ApiException;
    ProductDTO getProductById(Integer id)  throws ApiException;
    ProductDTO updateProduct(Integer id, ProductDTO productDTO)  throws ApiException;
    void deleteProduct(Integer id)  throws ApiException;
}
