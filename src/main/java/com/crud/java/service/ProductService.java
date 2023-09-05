package com.crud.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.java.entity.Product;
import com.crud.java.repo.ProductRepository;
import com.crud.java.utils.BaseResponse;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<BaseResponse<List<Product>>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        BaseResponse<List<Product>> response = new BaseResponse<>(true, "Products retrieved successfully", products, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<BaseResponse<Product>> getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            BaseResponse<Product> response = new BaseResponse<>(true, "Product found", optionalProduct.get(), HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            BaseResponse<Product> response = new BaseResponse<>(false, "Product not found", null, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<BaseResponse<Product>> createProduct(Product product) {
        Product createdProduct = productRepository.save(product);
        BaseResponse<Product> response = new BaseResponse<>(true, "Product created successfully", createdProduct, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse<Product>> updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            Product updated = productRepository.save(updatedProduct);
            BaseResponse<Product> response = new BaseResponse<>(true, "Product updated successfully", updated, HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            BaseResponse<Product> response = new BaseResponse<>(false, "Product not found", null, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<BaseResponse<String>> deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            BaseResponse<String> response = new BaseResponse<>(true, "Product deleted successfully", null, HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            BaseResponse<String> response = new BaseResponse<>(false, "Product not found", null, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
