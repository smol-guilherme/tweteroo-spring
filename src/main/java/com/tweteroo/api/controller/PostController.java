package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.model.Post;
import com.tweteroo.api.service.PostService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tweets")
public class PostController {

  private PostService service;

  @PostMapping
  public String create(@RequestBody PostDTO data) {
    service.create(data);
    return "OK";
  }

  @GetMapping
  public List<Post> getList(@RequestParam(required = false) int page) {
    return service.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> listById(@PathVariable Long id) {
    return service.listPostsById(id);
  }

}
