package com.userfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("primaryAccount")
    private String primaryAccount(){
        return "primaryAccount";
    }
    @RequestMapping("savingsAccount")
    private String savingsAccount(){
        return "savingsAccount";
    }

}
