package com.example.demo.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;

public interface Repository extends JpaRepository <Product, Long> {

    List<Product> findByNameLike(String name);

    List<Product> findAllByOrderByNameAsc();
    List<Product> findAllByOrderByNameDesc();

    List<Product> findByPriceLessThan(int price);

}
