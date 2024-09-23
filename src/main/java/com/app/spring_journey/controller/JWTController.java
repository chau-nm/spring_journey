package com.app.spring_journey.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring_journey.lib.JWTToken;

@RestController
@RequestMapping("/api/jwt")
public class JWTController {

  @Autowired
  private JWTToken jwt;
  
  @GetMapping("/encrypt")
  public String encrypt(@RequestParam String plaintext) throws NoSuchAlgorithmException {
    return jwt.encrypt(plaintext);
  }

  @GetMapping("/decrypt")
  public String decrypt(@RequestParam String encoded) {
    return jwt.decrypt(encoded);
  }
}
