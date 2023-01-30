package com.crm.prototype.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest // this creates the test database and autowires the repository as well
class CustomerRepositoryIT {

    @Autowired
    private CustomerRepository underTest;

    @AfterEach // after each test we will have a clean test
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfCustomerExistsByEmail() {

        // given
        CustomerEntity customerEntity = new CustomerEntity(
                "ayush",
                "kaushik",
                "canada",
                "test address",
                "123-456-7890",
                "ayushkaushik305@gmail.com"
        );

        underTest.save(customerEntity);

        // when
        Optional<CustomerEntity> expectedCustomerEntity = underTest.findByEmail("ayushkaushik305@gmail.com");

        // then
        assertThat(expectedCustomerEntity).isNotNull();
        assertThat(expectedCustomerEntity.get().getEmail()).isEqualTo("ayushkaushik305@gmail.com");
    }

    @Test
    void itShouldCheckIfCustomerDoesNotExistsByEmail() {

        // given
        String email = "doesnotexist@test.com";

        // when
        Optional<CustomerEntity> expectedCustomerEntity = underTest.findByEmail(email);

        // then
        assertThat(expectedCustomerEntity).isEmpty();
    }
}