package com.tweteroo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class User {

  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(length = 64, nullable = false)
  private String name;

  @Column(length = 128, nullable = false)
  private String avatarUrl;

}
