package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.repository.Repository;


@RestController
public class ProductController {

    @Autowired
    Repository repository;

    @GetMapping("/init")
    void init(){
        repository.save(new Product("Chair", 100));
        repository.save(new Product("Table", 130));
        repository.save(new Product("Fan", 60));
        repository.save(new Product("Printer", 200));
        repository.save(new Product("Projector", 220));
    }

    @GetMapping("/all")
    public List<Product> all() {
        return repository.findAll();
    }

    @GetMapping("/search/{name}")
    public List<Product> search (@PathVariable String name){
        return repository.findByNameLike(name);
    }
    
    @GetMapping("/product/{order}")
    public List<Product> getAllProducts(@PathVariable String order) {
        if ((order.toUpperCase()).equals("ASC")) {
            return repository.findAllByOrderByNameAsc();
        } else if ((order.toUpperCase()).equals("DESC")) {
            return repository.findAllByOrderByNameDesc();
        } else {
            throw new IllegalArgumentException();
        }
    }
    @GetMapping("/product/cheaper/{price}")
    public List<Product> productLessthanPrice(@PathVariable int price){
     return repository.findByPriceLessThan(price);
    }

}
    
