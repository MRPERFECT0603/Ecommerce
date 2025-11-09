package com.projects.EcommerceBackend.Gateways;

import com.projects.EcommerceBackend.DTOs.ProductDTO;

import java.util.List;

public interface IProductGateway {

    List<ProductDTO> getAllProducts();
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO getProductById(Integer id);
    ProductDTO updateProduct(Integer id, ProductDTO productDTO);
    void deleteProduct(Integer id);
}
