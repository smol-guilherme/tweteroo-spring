package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.PostDTO;
import com.tweteroo.api.model.Post;
import com.tweteroo.api.service.PostService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/tweets")
public class PostController {

  @Autowired
  private PostService service;

  @PostMapping
  public HttpStatus create(@RequestBody PostDTO data, @RequestHeader("user") String user) {
    service.create(data, user);
    return HttpStatus.CREATED;
  }

  @GetMapping
  public Page<Post> getList(@RequestParam String page) {
    return service.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> listById(@PathVariable Long id) {
    return service.listPostsById(id);
  }

}
