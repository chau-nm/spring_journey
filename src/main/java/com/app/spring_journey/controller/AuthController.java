package com.app.spring_journey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring_journey.model.LoginPayload;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @PostMapping("/login")
  public boolean login(@RequestBody LoginPayload loginPayload) {
    if (loginPayload.getUsername().equals("admin") && loginPayload.getPassword().equals("admin")) {
      return true;
    }
    return false;
  }

  @GetMapping("/hello")
  public String sayHello() {
    return "Hello";
  }
}
