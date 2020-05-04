package com.application.project.data.repository;

import com.application.project.data.modal.CustomerOrder;
import com.application.project.data.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
