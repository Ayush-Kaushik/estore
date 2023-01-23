package com.crm.prototype.customer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService
                .getAllCustomers()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createCustomer(@RequestBody CustomerCreateDTO customerDetails) {
        CustomerEntity customer = modelMapper.map(customerDetails, CustomerEntity.class);
        customerService.createCustomer(customer);
        return "Saved";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String updateCustomer(@RequestBody CustomerCreateDTO customerDetails) {
        CustomerEntity customer = modelMapper.map(customerDetails, CustomerEntity.class);
        customerService.createCustomer(customer);
        return "Saved";
    }
}