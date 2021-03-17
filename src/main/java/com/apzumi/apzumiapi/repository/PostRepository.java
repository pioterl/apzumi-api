package com.apzumi.apzumiapi.repository;

import com.apzumi.apzumiapi.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
