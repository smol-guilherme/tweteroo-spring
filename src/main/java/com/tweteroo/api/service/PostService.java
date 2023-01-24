package com.tweteroo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.repository.PostRepository;
import com.tweteroo.api.repository.UserRepository;
import com.tweteroo.api.model.Post;
import com.tweteroo.api.model.Users;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  @Autowired
  UserRepository getAvatar;

  public void create(PostDTO req, String user) {
    Users userFound = getAvatar.findByUsername(user);

    PostDTO entry = new PostDTO(user, userFound.getAvatar(), req.text());
    Post newData = new Post(entry);
    repository.save(newData);
  }

  public Page<Post> findAll(String page) {
    Pageable pageable = PageRequest.of(Integer.parseInt(page), 5);
    return repository.findAll(pageable);
  }

  public ResponseEntity<Post> listPostsById(Long id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

}
