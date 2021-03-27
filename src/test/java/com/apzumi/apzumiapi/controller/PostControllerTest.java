package com.apzumi.apzumiapi.controller;

import com.apzumi.apzumiapi.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostControllerTest {

    @Autowired
    private PostController postController;

    @Test
    void shouldDeletePostThenFindNone() {
        Long existingNumber = 1L;

        assertThat(postController.delete(existingNumber)).isEqualTo("Deleting post with ID 1");
        assertThat(postController.delete(existingNumber)).isEqualTo("There is no post with ID 1");
    }

    @Test
    void shouldNotFindPostToDelete() {
        Long notExistingNumber = 101L;

        assertThat(postController.delete(notExistingNumber)).isEqualTo("There is no post with ID 101");
    }

    @Test
    void shouldUpdatePost() {
        Post existingPost = new Post();
        existingPost.setId(2L);
        existingPost.setTitle("modified");
        existingPost.setBody("modified");

        assertThat(postController.updatePost(existingPost)).isEqualTo("Updating post with ID 2");
    }

    @Test
    void shouldNotFindPostToUpdate() {
        Post notExistingPost = new Post();
        notExistingPost.setId(0L);
        notExistingPost.setTitle("modified");
        notExistingPost.setBody("modified");

        assertThat(postController.updatePost(notExistingPost)).isEqualTo("There is no post with ID 0");
    }
}