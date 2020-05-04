package com.application.project.rest.controller;

import com.application.project.data.modal.Customer;
import com.application.project.data.modal.CustomerOrder;
import com.application.project.data.modal.OrderItem;
import com.application.project.data.modal.Product;
import com.application.project.service.CustomerOrderService;
import com.application.project.service.CustomerService;
import com.application.project.service.ProductService;
import com.application.project.service.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    //@PreAuthorize("#oauth2.hasScope('read') and hasRole('USER')")
    @GetMapping("orders")
    public List<CustomerOrder> getAllOrders() {
        return customerOrderService.list();
    }

    @GetMapping("orders/{orderId}")
    public CustomerOrder getOrderById(@PathVariable String orderId) {
        try {
            return customerOrderService.findById(Long.parseLong(orderId));
        } catch (ProjectDetailsNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "product Details with id " + orderId + " Not Found", exception);
        }

    }

    @PostMapping("orders/{customerId}")
    public CustomerOrder createPost(@PathVariable String customerId, @RequestBody CustomerOrder customerOrder) throws ProjectDetailsNotFoundException {
        Customer customer = customerService.findById(Long.parseLong(customerId));
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.addAll(customerOrder.getOrderItems());
        customerOrder.setOrderItems(null);
        customerOrder.setCustomer(customer);
        CustomerOrder customerOrder1 = customerOrderService.save(customerOrder);

        for (OrderItem orderItem : orderItems) {
            Product product = productService.findById(Long.parseLong(orderItem.product_id));
            orderItem.setCustomerOrder(customerOrder1);
            orderItem.setProduct(product);
        }
        customerOrder1.setOrderItems(orderItems);
        return customerOrderService.save(customerOrder1);
    }
}
