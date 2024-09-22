package com.app.spring_journey.lib;

import org.springframework.beans.factory.annotation.Value;

public class JWTToken {
  @Value("${jwt.secret}")
    private String secretKey;
	
}
