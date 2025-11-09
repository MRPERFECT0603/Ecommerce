package com.projects.EcommerceBackend.Controllers;

import com.projects.EcommerceBackend.DTOs.ProductDTO;
import com.projects.EcommerceBackend.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getALlProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Integer id)
    {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}
