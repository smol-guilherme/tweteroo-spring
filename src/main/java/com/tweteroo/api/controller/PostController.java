package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.model.Post;
import com.tweteroo.api.repository.PostRepository;

@RestController
@RequestMapping("/tweets")
public class PostController {

  @Autowired
  private PostRepository repository;

  @PostMapping
  public String create(@RequestBody PostDTO req) {
    repository.save(new Post(req));
    return "OK";
  }

  @GetMapping
  public List<Post> listPage(@RequestParam(required = false) int page) {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> listPostsByUsername(@PathVariable Long id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
}
