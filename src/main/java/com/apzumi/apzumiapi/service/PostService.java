package com.apzumi.apzumiapi.service;

import com.apzumi.apzumiapi.repository.PostRepository;
import com.apzumi.apzumiapi.domain.Post;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@EnableScheduling
public class PostService {

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    @Scheduled(fixedRate = 43200000)
    public void downloadPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        try {
            Post[] posts = restTemplate.getForObject(url, Post[].class);
            List<Post> downloadedPosts = Optional.ofNullable(posts).map(Arrays::asList).orElseGet(ArrayList::new);
            saveAll(downloadedPosts);
            System.out.println("Posts saved to database!");
        } catch (HttpStatusCodeException exception) {
            int statusCode = exception.getStatusCode().value();
            System.out.println("JSON API URL returns: " + statusCode);
        }
    }

    public Iterable<Post> listAll() {
        return postRepository.findAll();
    }

    public Iterable<Post> findAll(String title) {
        return postRepository.findAllByTitleContains(title);
    }

    public void saveAll(List<Post> post) {
        postRepository.saveAll(post);
    }
}
