package com.tweteroo.api.model;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Post {

  public Post(PostDTO data) {
    this.name = data.name();
    this.avatarUrl = data.avatarUrl();
    this.text = data.text();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(length = 64, nullable = false)
  private String name;

  @Column(length = 128, nullable = false)
  private String avatarUrl;

  @Column(length = 240, nullable = false)
  private String text;

}
