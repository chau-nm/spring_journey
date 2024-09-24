package com.app.spring_journey.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String uuid;
  private String roleName;
  @ManyToMany(mappedBy="roles")
  private List<User> users;
}
