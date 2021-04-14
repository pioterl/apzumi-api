package com.apzumi.apzumiapi.repository;

import com.apzumi.apzumiapi.domain.Post;
import com.apzumi.apzumiapi.domain.PostDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByTitleContains(String title);

}
