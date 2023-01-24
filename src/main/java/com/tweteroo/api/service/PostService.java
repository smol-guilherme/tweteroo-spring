package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.repository.PostRepository;
import com.tweteroo.api.repository.UserRepository;
import com.tweteroo.api.model.Post;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  @Autowired
  UserRepository getAvatar;

  public String create(PostDTO req) {
    Post newData = new Post(req);
    repository.save(newData);
    return "OK";
  }

  public Page<Post> findAll(String page) {
    Pageable pageable = PageRequest.of(Integer.parseInt(page), 5);
    return repository.findAll(pageable);
  }

  public ResponseEntity<Post> listPostsById(Long id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

}
