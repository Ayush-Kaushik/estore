package com.crm.prototype;

import com.crm.prototype.customer.CustomerCreateDTO;
import com.crm.prototype.customer.CustomerDTO;
import com.crm.prototype.customer.CustomerEntity;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

public class MapperTests extends TestCase {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void setUp() {

    }

    @Test
    public void checkCreateCustomerToCustomerEntityMapper() {
        CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO();

        customerCreateDTO.setAddress("test address");
        customerCreateDTO.setCountry("test");
        customerCreateDTO.setFirstName("test");
        customerCreateDTO.setLastName("test");
        customerCreateDTO.setPhoneNumber("123-456-7890");

        CustomerEntity customerEntity = modelMapper.map(customerCreateDTO, CustomerEntity.class);

        Assert.assertEquals(customerEntity.getEmail(), customerCreateDTO.getEmail());
        Assert.assertEquals(customerEntity.getAddress(), customerCreateDTO.getAddress());
        Assert.assertEquals(customerEntity.getFirstName(), customerCreateDTO.getFirstName());
        Assert.assertEquals(customerEntity.getLastName(), customerCreateDTO.getLastName());
        Assert.assertEquals(customerEntity.getCountry(), customerCreateDTO.getCountry());
    }

    @Test
    public void checkCustomerEntityToCustomerDTOMapper() {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setAddress("test address");
        customerEntity.setCountry("test");
        customerEntity.setFirstName("test");
        customerEntity.setLastName("test");
        customerEntity.setPhoneNumber("123-456-7890");

        CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);

        Assert.assertEquals(customerEntity.getAddress(), customerDTO.getAddress());
        Assert.assertEquals(customerEntity.getFirstName(), customerDTO.getFirstName());
        Assert.assertEquals(customerDTO.getLastName(), customerEntity.getLastName());
        Assert.assertEquals(customerDTO.getCountry(), customerEntity.getCountry());
    }

    @Test
    public void checkCustomerEntityToCreateCustomerDTOMapper() {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setAddress("test address");
        customerEntity.setCountry("test");
        customerEntity.setFirstName("test");
        customerEntity.setLastName("test");
        customerEntity.setPhoneNumber("123-456-7890");

        CustomerCreateDTO customerCreateDTO = modelMapper.map(customerEntity, CustomerCreateDTO.class);

        Assert.assertEquals(customerEntity.getAddress(), customerCreateDTO.getAddress());
        Assert.assertEquals(customerEntity.getFirstName(), customerCreateDTO.getFirstName());
        Assert.assertEquals(customerCreateDTO.getLastName(), customerEntity.getLastName());
        Assert.assertEquals(customerCreateDTO.getCountry(), customerEntity.getCountry());
    }
}
