package com.apzumi.apzumiapi.service;

import com.apzumi.apzumiapi.repository.PostRepository;
import com.apzumi.apzumiapi.domain.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    public List<Post> downloadPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Post[] posts = restTemplate.getForObject(url, Post[].class);
        assert posts != null;
        return Arrays.asList(posts);
    }

    public Iterable<Post> list() {

        return postRepository.findAll();
    }

    public Iterable<Post> save(List<Post> post) {
        return postRepository.saveAll(post);
    }
}
