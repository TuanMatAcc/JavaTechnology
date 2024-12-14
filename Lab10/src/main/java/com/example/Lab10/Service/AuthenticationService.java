package com.example.Lab10.Service;

import com.example.Lab10.Utilities.LoginRequest;
import com.example.Lab10.Model.Account;
import com.example.Lab10.Utilities.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;

    public LoginResponse register(Account account) {
        // create user wih hash password
        var newUser = Account.builder().
                username(account.getUsername())
                .password(passwordEncoder.encode(account.getPassword()))
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .build();
        // check if username is already taken
        Account user = accountService.register(newUser);
        // username is taken
        if(user == null) {
            return null;
        }
        // username is available
        String jwtToken = jwtService.generateToken(newUser.getUsername());
        return LoginResponse.builder().token(jwtService.generateToken(jwtToken)).user(user).build();
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (request.getUsername(), request.getPassword())
        );
        String jwtToken = jwtService.generateToken(request.getUsername());
        Account user = accountService.findByUsername(request.getUsername());
        return LoginResponse.builder().token(jwtToken).user(user).build();
    }
}

