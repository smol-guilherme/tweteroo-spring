package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UserRepository;

public class UserService {

  @Autowired
  private UserRepository repository;

  public String create(UserDTO data) {
    repository.save(new User(data));
    return "OK";
  }
}
