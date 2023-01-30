package com.crm.prototype.serviceuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceUserRepository extends JpaRepository<ServiceUser, Integer> {

    // this will help us retrieve service user by email id
    Optional<ServiceUser> findByEmail(String email);
}
