package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.repository.PostRepository;
import com.tweteroo.api.model.Post;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  public String create(PostDTO req) {
    repository.save(new Post(req));
    return "OK";
  }

  public List<Post> findAll(int page) {
    return repository.findAll();
  }

  public ResponseEntity<Post> listPostsById(Long id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

}
