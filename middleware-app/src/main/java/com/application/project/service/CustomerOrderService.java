package com.application.project.service;

import com.application.project.data.modal.Customer;
import com.application.project.data.modal.CustomerOrder;
import com.application.project.data.repository.CustomerOrderRepository;
import com.application.project.data.repository.CustomerRepository;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {


    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public List<CustomerOrder> list() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder findById(Long id) throws ProjectDetailsNotFoundException {
        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);
        if (! customerOrder.isPresent()) {
            throw new ProjectDetailsNotFoundException();
        }
        return customerOrder.get();
    }

    public CustomerOrder save(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    public void delete(CustomerOrder customerOrder) {
        customerOrderRepository.delete(customerOrder);
    }
}
