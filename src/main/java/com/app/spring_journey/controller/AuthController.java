package com.app.spring_journey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/server-login")
  public RedirectView login(@RequestParam String username, @RequestParam String password) {
    System.out.println("Start login");
    try {
      Authentication authenticationRequest = 
        UsernamePasswordAuthenticationToken.unauthenticated(username, password);
      authenticationManager.authenticate(authenticationRequest);
      return new RedirectView("/");
    } catch (AuthenticationException e) {
      return new RedirectView("login");
    }
  }
}
