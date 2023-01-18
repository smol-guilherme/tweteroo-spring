package com.tweteroo.api.model;

import com.tweteroo.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class User {

  public User(UserDTO data) {
    this.name = data.name();
    this.avatarUrl = data.avatar_url();
  }

  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(length = 64, nullable = false)
  private String name;

  @Column(length = 128, nullable = false)
  private String avatarUrl;

}
