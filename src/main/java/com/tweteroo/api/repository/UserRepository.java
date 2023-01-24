package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
  List<Users> findByName(String user);
}
