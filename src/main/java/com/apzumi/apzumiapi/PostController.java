package com.apzumi.apzumiapi;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final RestTemplate restTemplate;
    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/posts")
    public List<Object> getPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Object[] posts = restTemplate.getForObject(url, Object[].class);
        assert posts != null;
        return Arrays.asList(posts);
    }


}
