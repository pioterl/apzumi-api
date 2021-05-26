package com.apzumi.apzumiapi.controller;

import com.apzumi.apzumiapi.domain.Post;
import com.apzumi.apzumiapi.domain.PostDTO;
import com.apzumi.apzumiapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDTO> list() {
        postService.downloadPostAndCompare();
        return postService.listAll();
    }

    @PostMapping("/posts")
    public List<PostDTO> search(@RequestBody String title) {
        return postService.findAll(title);
    }

    @DeleteMapping(path="/posts/{id}")
    public String delete(@PathVariable Long id) {
        return postService.deleteById(id);
    }

    @PutMapping("/posts")
    public String updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

}
