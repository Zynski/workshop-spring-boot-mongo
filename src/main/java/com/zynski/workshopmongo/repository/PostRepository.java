package com.zynski.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zynski.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}

