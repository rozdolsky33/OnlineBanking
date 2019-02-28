package com.userfront.dao;

import com.userfront.domain.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by on 02/27/19.
 */
public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}
