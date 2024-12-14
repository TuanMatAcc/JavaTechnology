package com.example.Lab10.Controller;

import com.example.Lab10.Model.Account;
import com.example.Lab10.Service.AccountService;
import com.example.Lab10.Service.AuthenticationService;
import com.example.Lab10.Utilities.LoginRequest;
import com.example.Lab10.Utilities.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        LoginResponse loginResponse = authenticationService.login(request);
        if(loginResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong username or password");
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account user) {
        LoginResponse registeredAccount = authenticationService.register(user);
        if(registeredAccount == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username is already taken");
        }
        return ResponseEntity.status(HttpStatus.OK).body(registeredAccount);
    }
}
