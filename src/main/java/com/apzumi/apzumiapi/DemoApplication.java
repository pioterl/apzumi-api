package com.apzumi.apzumiapi;

import com.apzumi.apzumiapi.domain.Post;
import com.apzumi.apzumiapi.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner runner(PostService postService) {
        return args -> {
            List<Post> posts = postService.downloadPosts();
            postService.save(posts);
            System.out.println("Posts Saved!");
        };
    }

}
