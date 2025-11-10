package com.projects.EcommerceBackend.Services;

import com.projects.EcommerceBackend.CustomExceptions.ApiException;
import com.projects.EcommerceBackend.DTOs.ProductDTO;
import com.projects.EcommerceBackend.Gateways.IProductGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {
        private final IProductGateway ProductGateway;


        public ProductService(IProductGateway ProductGateway) {
            this.ProductGateway = ProductGateway;
        }

        public List<ProductDTO> getAllProducts() throws ApiException {
            return ProductGateway.getAllProducts();
        }

        public ProductDTO addProduct(ProductDTO productDTO) throws ApiException  {
            return ProductGateway.addProduct(productDTO);
        }

        public ProductDTO getProductById(Integer id) throws ApiException
        {
            return ProductGateway.getProductById(id);
        }

        public ProductDTO updateProduct(Integer id, ProductDTO productDTO) throws ApiException  {
            return ProductGateway.updateProduct(id, productDTO);
        }

        public void deleteProduct(Integer id) throws ApiException  {
            ProductGateway.deleteProduct(id);
        }
}
