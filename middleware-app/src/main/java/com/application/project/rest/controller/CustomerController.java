package com.application.project.rest.controller;

import com.application.project.data.modal.Customer;
import com.application.project.data.modal.Product;
import com.application.project.service.CustomerService;
import com.application.project.service.ProductService;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    //@PreAuthorize("#oauth2.hasScope('read') and hasRole('USER')")
    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        return customerService.list();

    }

    @GetMapping("customers/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
        try {
            return customerService.findById(Long.parseLong(customerId));
        } catch (ProjectDetailsNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "product Details with id " + customerId + " Not Found", exception);
        }

    }

    @PostMapping("customers")
    public Customer createPost(@RequestBody Customer customer) {
        //System.out.println(phonebook.getId() + " :: " + phonebook.getName());
        return customerService.save(customer);
    }
}
