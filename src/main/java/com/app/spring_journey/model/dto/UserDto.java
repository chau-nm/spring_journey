package com.app.spring_journey.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
  private String id;
  private String fname;
  private String age;
}
