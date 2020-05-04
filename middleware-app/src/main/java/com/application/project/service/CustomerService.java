package com.application.project.service;

import com.application.project.data.modal.Customer;
import com.application.project.data.repository.CustomerRepository;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) throws ProjectDetailsNotFoundException {
        Optional<Customer> customers = customerRepository.findById(id);
        if (! customers.isPresent()) {
            throw new ProjectDetailsNotFoundException();
        }
        return customers.get();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
