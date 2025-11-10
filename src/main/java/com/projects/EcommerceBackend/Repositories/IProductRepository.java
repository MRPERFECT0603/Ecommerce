package com.projects.EcommerceBackend.Repositories;

import com.projects.EcommerceBackend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product, Integer> {
}
