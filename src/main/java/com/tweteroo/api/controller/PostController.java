package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  private String create(@RequestBody PostDTO req) {
    repository.save(new Post(req));
    return "OK";
  }

}
