package com.userfront.dao;

import com.userfront.domain.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by on 02/27/19.
 */
public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber(int accountNumber);
}
