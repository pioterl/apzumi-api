package com.apzumi.apzumiapi.service;

import com.apzumi.apzumiapi.repository.PostRepository;
import com.apzumi.apzumiapi.domain.Post;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
public class PostService {

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    @Scheduled(fixedRate = 43200000)
    public void downloadPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Post[] posts = restTemplate.getForObject(url, Post[].class);
        List<Post> downloadedPosts = Arrays.asList(posts);
        saveAll(downloadedPosts);
        System.out.println("Posts saved to database!");
    }

    public Iterable<Post> listAll() {
        return postRepository.findAll();
    }

    public void saveAll(List<Post> post) {
        postRepository.saveAll(post);
    }
}
