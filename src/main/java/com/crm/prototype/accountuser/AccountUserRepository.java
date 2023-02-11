package com.crm.prototype.accountuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountUserRepository extends JpaRepository<AccountUserEntity, Integer> {

    // this will help us retrieve service user by email id
    Optional<AccountUserEntity> findByEmail(String email);
}
