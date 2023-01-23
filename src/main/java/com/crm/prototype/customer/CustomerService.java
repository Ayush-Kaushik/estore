package com.crm.prototype.customer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();

        return customerEntities
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    public void createCustomer(CustomerCreateDTO customerCreateDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerCreateDTO, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    public void updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(customerUpdateDTO.getId());
        CustomerEntity customerEntity = optionalCustomerEntity.get();

        customerEntity.setFirstName(customerUpdateDTO.getFirstName());
        customerEntity.setLastName(customerUpdateDTO.getLastName());
        customerEntity.setPhoneNumber(customerUpdateDTO.getPhoneNumber());
        customerEntity.setAddress(customerUpdateDTO.getAddress());
        customerEntity.setCountry(customerUpdateDTO.getCountry());
        customerEntity.setEmail(customerUpdateDTO.getEmail());

        customerRepository.save(customerEntity);
    }
}