package com.smartzi.poc.redispoc.controller;

import com.smartzi.poc.redispoc.entity.Product;
import com.smartzi.poc.redispoc.repo.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productDAO.save(product);
    }

    @GetMapping
    public List<Product> findAllProduct() {
        return productDAO.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable long id) {
        return productDAO.findProductById(id);
    }

    @DeleteMapping
    public String deleteProduct(@PathVariable long id) {
        return productDAO.deleteProduct(id);
    }
}
