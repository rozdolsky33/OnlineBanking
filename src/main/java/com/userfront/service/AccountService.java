package com.userfront.service;

import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.SavingsAccount;
import com.userfront.service.UserServiceImpl.AccountServiceImpl;

import java.security.Principal;


public interface AccountService {
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();

    void deposit(AccountServiceImpl.AccountType accountType, double amount, Principal principal);
    void withdraw(AccountServiceImpl.AccountType accountType, double amount, Principal principal);

}