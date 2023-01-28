package com.crm.prototype.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query("FROM CustomerEntity c WHERE c.email in  ?1")
    Optional<CustomerEntity> findByEmail(String email);
}