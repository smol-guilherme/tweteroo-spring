package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.model.Post;
import com.tweteroo.api.repository.PostRepository;

@RestController
@RequestMapping("/api/post")
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

}
