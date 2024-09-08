package com.app.spring_journey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring_journey.model.LoginPayload;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/login")
  public boolean login(@RequestBody LoginPayload loginPayload) {
    System.out.println("Start login");
    try {
      Authentication authenticationRequest = 
        UsernamePasswordAuthenticationToken.unauthenticated(loginPayload.getUsername(), loginPayload.getPassword());
      authenticationManager.authenticate(authenticationRequest);
      return true;
    } catch (AuthenticationException e) {
      return false;
    }
  }

  @GetMapping("/hello")
  public String sayHello() {
    System.out.println("Hello");
    return "Hello";
  }
}
