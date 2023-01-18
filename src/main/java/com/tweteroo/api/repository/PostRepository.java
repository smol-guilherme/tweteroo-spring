package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
