package com.apzumi.apzumiapi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final RestTemplate restTemplate;

    public List<Object> downloadPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Object[] posts = restTemplate.getForObject(url, Object[].class);
        assert posts != null;
        return Arrays.asList(posts);
    }
}
