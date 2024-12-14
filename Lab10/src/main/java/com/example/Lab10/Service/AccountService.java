package com.example.Lab10.Service;

import com.example.Lab10.Model.Account;
import com.example.Lab10.Repository.AccountRepository;
import com.example.Lab10.Utilities.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account register(Account account) {
        if(accountRepository.findByUsername(account.getUsername()).isPresent()) {
            return null;
        }
        return accountRepository.save(account);
    }

    public boolean login(LoginRequest request) {
        Optional<Account> account = accountRepository.findByUsername(request.getUsername());
        if(account.isEmpty()) {
            return false;
        }
        return account.get().getPassword().equals(request.getPassword());
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElse(null);
    }
}
