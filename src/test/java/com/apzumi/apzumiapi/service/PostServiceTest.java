package com.apzumi.apzumiapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void shouldDownloadCompareAndSavePostsToDb() {
        assertThat(postService.downloadPostAndCompare()).isEqualTo("Posts compared and saved to database");
    }

}