package com.crud.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.java.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
