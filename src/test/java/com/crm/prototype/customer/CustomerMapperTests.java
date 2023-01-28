package com.crm.prototype.customer;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerMapperTests {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void canMapCustomerCreateDTOToCustomerEntity() {

        // given
        CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO(
                "testFirstName",
                "testLastName",
                "testCountry",
                "test address",
                "123-456-7890",
                "testEmail@test.com"
        );

        // when
        CustomerEntity customerEntity = modelMapper.map(customerCreateDTO, CustomerEntity.class);

        // then
        assertThat(customerEntity.getEmail()).isEqualTo(customerCreateDTO.getEmail());
        assertThat(customerEntity.getAddress()).isEqualTo(customerCreateDTO.getAddress());
        assertThat(customerEntity.getFirstName()).isEqualTo(customerCreateDTO.getFirstName());
        assertThat(customerEntity.getLastName()).isEqualTo(customerCreateDTO.getLastName());
        assertThat(customerEntity.getCountry()).isEqualTo(customerCreateDTO.getCountry());
    }

    @Test
    public void canMapCustomerEntityToCustomerDTO() {

        // given
        CustomerEntity customerEntity = new CustomerEntity(
                "testFirstName",
                "testLastName",
                "testCountry",
                "testAddress",
                "123-456-7890",
                "testemail@test.com"
        );

        // when
        CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);

        // then
        assertThat(customerEntity.getAddress()).isEqualTo(customerDTO.getAddress());
        assertThat(customerEntity.getFirstName()).isEqualTo(customerDTO.getFirstName());
        assertThat(customerDTO.getLastName()).isEqualTo(customerEntity.getLastName());
        assertThat(customerDTO.getCountry()).isEqualTo(customerEntity.getCountry());
    }

    @Test
    public void canMapCustomerEntityToCustomerCreateDTO() {

        // given
        CustomerEntity customerEntity = new CustomerEntity(
                "testFirstName",
                "testLastName",
                "testCountry",
                "testAddress",
                "123-456-7890",
                "testemail@test.com"
        );

        // when
        CustomerCreateDTO customerCreateDTO = modelMapper.map(customerEntity, CustomerCreateDTO.class);

        // then
        assertThat(customerEntity.getAddress()).isEqualTo(customerCreateDTO.getAddress());
        assertThat(customerEntity.getFirstName()).isEqualTo(customerCreateDTO.getFirstName());
        assertThat(customerCreateDTO.getLastName()).isEqualTo(customerEntity.getLastName());
        assertThat(customerCreateDTO.getCountry()).isEqualTo(customerEntity.getCountry());
    }
}
