package com.application.project.data.repository;

import com.application.project.data.modal.Customer;
import com.application.project.data.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
