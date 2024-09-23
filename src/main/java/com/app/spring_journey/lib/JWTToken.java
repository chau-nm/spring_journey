package com.app.spring_journey.lib;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.PublicJwk;

@Component
public class JWTToken {
 
  @Autowired
  KeyLocator keyLocator;

  public PublicJwk<RSAPublicKey> createRSAJWK() {
    KeyPair keyPair = Jwts.SIG.RS512.keyPair().build();
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    keyLocator.addKey("prk", privateKey);
    PublicJwk<RSAPublicKey> jwk = Jwks.builder().key(publicKey).build();
    return jwk;
  }
	
  public String encrypt(String plaintext) throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    PublicKey pubKey = keyPair.getPublic();
    PrivateKey priKey = keyPair.getPrivate();
    String keyId = "keyid";

    keyLocator.addKey(keyId, priKey);
    return Jwts.builder()
      .subject(plaintext)

      .header()
      .keyId(keyId)
      .and()

      .encryptWith(pubKey, Jwts.KEY.RSA1_5, Jwts.ENC.A256GCM)
      
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
