package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.Users;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public String create(UserDTO data) {
    System.out.println(data);
    repository.save(new Users(data));
    return "OK";
  }
}
