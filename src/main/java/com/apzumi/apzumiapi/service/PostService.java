package com.apzumi.apzumiapi.service;

import com.apzumi.apzumiapi.domain.Post;
import com.apzumi.apzumiapi.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
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
    private final static String API_URL = "https://jsonplaceholder.typicode.com/posts";

    @Bean
    public void downloadPostsToDb() {
        try {
            Post[] posts = restTemplate.getForObject(API_URL, Post[].class);
            List<Post> downloadedPosts = Optional.ofNullable(posts).map(Arrays::asList).orElseGet(ArrayList::new);
            saveAll(downloadedPosts);
            System.out.println("Posts saved to database!");
        } catch (HttpStatusCodeException exception) {
            int statusCode = exception.getStatusCode().value();
            System.out.println("JSON API URL returned " + statusCode);
        }
    }

    @Scheduled(cron = "0 0 23 * * *", zone="Europe/Warsaw")
    public void downloadPosts() {
        try {
            Post[] posts = restTemplate.getForObject(API_URL, Post[].class);
            for (Post apiNext : Optional.ofNullable(posts).map(Arrays::asList).orElseGet(ArrayList::new)) {
                for (Post dbNext : postRepository.findAll()) {
                    if (apiNext.getId().equals(dbNext.getId())) {
                        if (apiNext.getTitle().equals(dbNext.getTitle()) && apiNext.getBody().equals(dbNext.getBody())) {
                            postRepository.save(apiNext);
                        }
                    }
                }
            }
        } catch (HttpStatusCodeException exception) {
            int statusCode = exception.getStatusCode().value();
            System.out.println("JSON API URL returned " + statusCode);
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

    public String deleteById(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return "Deleting post with ID " + id;
        } else {
            return "There is no post with ID " + id;
        }
    }

    public String updatePost(Post post) {
        if (postRepository.existsById(post.getId())) {
            Post existingPost = postRepository.findById(post.getId()).orElse(null);
            existingPost.setTitle(post.getTitle());
            existingPost.setBody(post.getBody());
            existingPost.setUserId(existingPost.getUserId());
            postRepository.save(existingPost);
            return "Updating post with ID " + post.getId();
        } else {
            return "There is no post with ID " + post.getId();
        }
    }
}
