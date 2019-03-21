package com.userfront.controller;

import com.userfront.domain.*;
import com.userfront.service.AccountService;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;
import com.userfront.service.UserServiceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.security.Principal;
import java.util.List;

@Controller
@Validated
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/primaryAccount")
    public String primaryAccount(Model model, Principal principal) {

        List<PrimaryTransaction>primaryTransactionsList = transactionService.findPrimaryTransactionList(principal.getName());
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("primaryTransactionList", primaryTransactionsList);

        return "primaryAccount";
    }

    @RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal) {

        List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());
        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);

        return "savingsAccount";
    }


    @RequestMapping(value = "/deposit",  method = RequestMethod.GET)
    public String deposit(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "deposit";
    }

    @RequestMapping(value = "/deposit")
    public String deposit(@ModelAttribute("amount") Double amount,
                          @ModelAttribute("accountType") String accountType,
                         Principal principal) throws Exception {

        if (amount < 0) throw new Exception("Must be a positive number" + amount);

        if (accountType == null || accountType.trim().isEmpty()) {
            throw new Exception("Please select AccountType for deposit" + accountType);
        }
        accountService.deposit(AccountServiceImpl.AccountType.valueOf(accountType), amount, principal);
        return "redirect:/userFront";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdraw(@ModelAttribute("amount") Double amount,
                           @ModelAttribute("accountType") String accountType,
                            Principal principal) throws Exception {

        if (accountType == null || accountType.trim().isEmpty()) {
            throw new Exception ("Please select AccountType for withdrawal");
        }

        if (amount < 0) throw new Exception("Must be a positive number" + amount);

        accountService.withdraw(AccountServiceImpl.AccountType.valueOf(accountType), amount, principal);
        return "redirect:/userFront";
    }

}