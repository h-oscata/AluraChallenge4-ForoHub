package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.JWTtoken;
import com.alura.ForoHub.service.auth.TokenService;
import com.alura.ForoHub.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTtoken> autenticateUser(@RequestBody @Valid User user) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        );

        var autenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((User) autenticatedUser.getPrincipal());

        return ResponseEntity.ok(new JWTtoken(JWTtoken));
    }
}
