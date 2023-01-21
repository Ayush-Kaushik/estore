package com.crm.prototype.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @RequestMapping("/customers")
    public List<Customer> getCustomers() {
        return List.of(new Customer(123, "hello", "test", "Canada", "test address", "123-456-780"));
    }

}