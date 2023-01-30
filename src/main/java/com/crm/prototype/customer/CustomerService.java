package com.crm.prototype.customer;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
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

    public CustomerDTO getCustomerById(int id) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        CustomerEntity customerEntity = optionalCustomerEntity.get();
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerDTO getCustomerByEmail(String email) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByEmail(email);
        CustomerEntity customerEntity = optionalCustomerEntity.get();
        return modelMapper.map(customerEntity, CustomerDTO.class);
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