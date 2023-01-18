package com.tweteroo.api.model;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Post {

  public Post(PostDTO data) {
    this.name = data.name();
    this.avatarUrl = data.avatarUrl();
    this.text = data.text();
  }

  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(length = 64, nullable = false)
  private UserDTO name;

  @Column(length = 128, nullable = false)
  private UserDTO avatarUrl;

  @Column(length = 240, nullable = false)
  private String text;

}
