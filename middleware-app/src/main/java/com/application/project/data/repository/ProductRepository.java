package com.application.project.data.repository;

import com.application.project.data.modal.Product;
import com.application.project.data.modal.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
