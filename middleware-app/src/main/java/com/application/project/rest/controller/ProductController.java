package com.application.project.rest.controller;

import com.application.project.data.modal.Product;
import com.application.project.service.ProductService;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    //@PreAuthorize("#oauth2.hasScope('read') and hasRole('USER')")
    @GetMapping("products")
    public List<Product> getAllProducts() {
        return productService.list();

    }

    @GetMapping("products/{productId}")
    public Product getProductById(@PathVariable String productId) {
        try {
            return productService.findById(Long.parseLong(productId));
        } catch (ProjectDetailsNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "product Details with id " + productService + " Not Found", exception);
        }

    }

    @PostMapping("products")
    public Product createPost(@RequestBody Product product) {
        //System.out.println(phonebook.getId() + " :: " + phonebook.getName());
        return productService.save(product);
    }
}
