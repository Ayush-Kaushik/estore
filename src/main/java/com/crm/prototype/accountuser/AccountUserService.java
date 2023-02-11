package com.crm.prototype.accountuser;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountUserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountUserRepository accountUserRepository;

    public AccountUserDTO getAccountUserByEmail(String email) {
        Optional<AccountUserEntity> optionalAccountUserEntity = accountUserRepository.findByEmail(email);
        AccountUserEntity accountUserEntity = optionalAccountUserEntity.get();
        return modelMapper.map(accountUserEntity, AccountUserDTO.class);
    }

    public void createAccountUser(AccountUserCreateDTO accountUserCreateDTO) {
        AccountUserEntity accountUserEntity = modelMapper.map(accountUserCreateDTO, AccountUserEntity.class);
        accountUserRepository.save(accountUserEntity);
    }
}
