package com.crm.prototype.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ModelMapper modelMapper;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(modelMapper, customerRepository);
    }

    @Test
    void canGetAllCustomers() {
        // when
        underTest.getAllCustomers();

        // then
        verify(customerRepository).findAll();
    }

    @Test
    void canGetCustomerById() {

        // given
        int givenCustomerId = 12345;
        CustomerEntity expectedCustomerEntity = new CustomerEntity(
                "ayush",
                "kaushik",
                "canada",
                "test address",
                "123-456-7890",
                "ayushkaushik305@gmail.com");

        CustomerDTO expectedCustomerDTO = new CustomerDTO(
                "ayush",
                "kaushik",
                "canada",
                "test address",
                "123-456-7890",
                "ayushkaushik305@gmail.com"
        );

        // when
        when(customerRepository.findById(givenCustomerId)).thenReturn(java.util.Optional.of(expectedCustomerEntity));
        when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(expectedCustomerDTO);
        CustomerDTO customerDTO = underTest.getCustomerById(givenCustomerId);

        // then
        assertThat(customerDTO).isEqualTo(expectedCustomerDTO);
    }

    @Test
    @Disabled
        // write later
    void getCustomerByEmail() {
    }

    @Test
    void canCreateCustomer() {
        // given
        CustomerEntity expectedCustomerEntity = new CustomerEntity(
                "ayush",
                "kaushik",
                "canada",
                "test address",
                "123-456-7890",
                "ayushkaushik305@gmail.com"
        );

        CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO(
                "ayush",
                "kaushik",
                "canada",
                "test address",
                "123-456-7890",
                "ayushkaushik305@gmail.com"
        );

        when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(expectedCustomerEntity);

        // when
        underTest.createCustomer(customerCreateDTO);


        // then
        ArgumentCaptor<CustomerEntity> customerEntityArgumentCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerRepository).save(customerEntityArgumentCaptor.capture());
        CustomerEntity capturedCustomerEntity = customerEntityArgumentCaptor.getValue();
        assertThat(capturedCustomerEntity).isEqualTo(expectedCustomerEntity);
    }

    @Test
    @Disabled
        // write later
        // @Disabled annotation before a test will prevent it from running
    void updateCustomer() {
    }
}