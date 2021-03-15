package com.apzumi.apzumiapi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/posts")
    public List<Object> getPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Object[] objects = restTemplate.getForObject(url, Object[].class);

        assert objects != null;
        return Arrays.asList(objects);
    }


}
