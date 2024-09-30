package org.example.controller;

import org.example.entity.Account;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    public AccountRepository accountRepository;

    @GetMapping("/account/{id}")
    public ResponseEntity<String> getAccount(@PathVariable("id") Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(account.get().getHolderName(), HttpStatus.OK);
        }
    }
}
