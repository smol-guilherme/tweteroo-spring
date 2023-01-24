package com.tweteroo.api.model;

import com.tweteroo.api.dto.PostDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Post {

  public Post(PostDTO data) {
    this.name = data.user();
    this.avatarUrl = data.avatar();
    this.text = data.text();
  }

  public void setAvatar(String data) {
    this.avatarUrl = data;
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
