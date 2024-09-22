package com.app.spring_journey.lib;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JWTToken {
 
  @Autowired
  KeyLocator keyLocator;
	
  public String encrypt(String plaintext) {
    SecretKey key = Jwts.SIG.HS256.key().build();
    String keyId = "keyid";
    keyLocator.addKey(keyId, key);
    return Jwts.builder()
      .subject(plaintext)

      .header()
      .keyId(keyId)
      .and()

      .signWith(key)
      
      .compact();
  }

  public String decrypt(String encoded) {

    return Jwts
      .parser()
      
      .keyLocator(keyLocator)

      .build()
      
      .parse(encoded)
      
      .toString();
  }
}
