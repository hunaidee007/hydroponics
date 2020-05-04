package com.application.project.service;

import com.application.project.data.modal.Product;
import com.application.project.data.repository.ProductRepository;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(Long id) throws ProjectDetailsNotFoundException {
        Optional<Product> products = productRepository.findById(id);
        if (! products.isPresent()) {
            throw new ProjectDetailsNotFoundException();
        }
        return products.get();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

}
