package com.apzumi.apzumiapi.controller;

import com.apzumi.apzumiapi.domain.Post;
import com.apzumi.apzumiapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public Iterable<Post> list() {
        postService.downloadPosts();
        return postService.listAll();
    }

    @PostMapping("/posts")
    public Iterable<Post> search(@RequestBody String title) {
        return postService.findAll(title);
    }

    @DeleteMapping(path="/posts/{id}")
    public void delete(@PathVariable Long id) {
        postService.deleteById(id);
    }

}
