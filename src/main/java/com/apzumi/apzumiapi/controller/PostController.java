package com.apzumi.apzumiapi.controller;

import com.apzumi.apzumiapi.domain.Post;
import com.apzumi.apzumiapi.repository.PostRepository;
import com.apzumi.apzumiapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/posts")
    public Iterable<Post> list() {
        return postService.list();
    }

}
