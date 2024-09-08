package com.app.spring_journey.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginPayload {
  private String username;
  private String password;
}
