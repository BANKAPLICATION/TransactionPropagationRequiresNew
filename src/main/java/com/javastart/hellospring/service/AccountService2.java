package com.javastart.hellospring.service;

import com.javastart.hellospring.entity.Account;
import com.javastart.hellospring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService2 {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService2(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW) // there is will be created a new transaction and the exception which happen in root method will be ignored
    // but if the methods are placed in the same class or service and exception happen then this annotation ignored, because the same proxy
    public void saveAccount2() {
        //
        Account account3 = new Account("Account3", "email", 4000);
        accountRepository.save(account3);
        //
    }
}
