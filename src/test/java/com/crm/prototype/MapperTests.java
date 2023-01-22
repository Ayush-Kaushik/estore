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
        customerCreateDTO.setPhonenumber("123-456-7890");

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

        customerEntity.setId(123);
        customerEntity.setAddress("test address");
        customerEntity.setCountry("test");
        customerEntity.setFirstName("test");
        customerEntity.setLastName("test");
        customerEntity.setPhoneNumber("123-456-7890");

        CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);

        Assert.assertEquals(customerDTO.getId(), customerEntity.getId());
        Assert.assertEquals(customerDTO.getAddress(), customerEntity.getAddress());
        Assert.assertEquals(customerDTO.getFirstName(), customerEntity.getFirstName());
        Assert.assertEquals(customerDTO.getLastName(), customerEntity.getLastName());
        Assert.assertEquals(customerDTO.getCountry(), customerEntity.getCountry());
    }


}
