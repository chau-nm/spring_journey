package com.app.spring_journey.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPayload {
  private String username;
  private String password;
}
