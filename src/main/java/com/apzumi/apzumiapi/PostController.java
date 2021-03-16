package com.apzumi.apzumiapi;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/posts")
    public List<Object> getPosts() {
        return postService.downloadPosts();
    }

}
