package com.app.spring_journey.lib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JWTToken {
  @Value("secret_key")
  private String secretKey;
	
  public String encrypt(String plaintext) {
    return Jwts.builder().subject(plaintext).compact();
  }

  public String decrypt(String encoded) {
    return Jwts.parser().unsecured().build().parse(encoded).toString();
  }
}
