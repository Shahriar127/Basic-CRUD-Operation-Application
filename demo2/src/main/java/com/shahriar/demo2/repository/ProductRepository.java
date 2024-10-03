package com.shahriar.demo2.repository;

import com.shahriar.demo2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByIdAndIsActiveTrue(Long id);
    List<Product> findAllByActiveTrue();
    

}
