package com.apzumi.apzumiapi.controller;

import com.apzumi.apzumiapi.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PostControllerTest {

    @Autowired
    private PostController postController;

    @Test
    void shouldDeletePostThenFindNone() {
        Long existingNumber = 1L;

        assertEquals("Deleting post with ID 1", postController.delete(existingNumber));
        assertEquals("There is no post with ID 1", postController.delete(existingNumber));
    }

    @Test
    void shouldFindWrongId() {
        Long notExistingNumber = 101L;

        assertEquals("There is no post with ID 101", postController.delete(notExistingNumber));
    }

    @Test
    void shouldUpdatePost() {
        Post existingPost = new Post();
        existingPost.setId(2L);
        existingPost.setTitle("modified");
        existingPost.setBody("modified");

        assertEquals("Updating post with ID 2", postController.updatePost(existingPost));
    }

    @Test
    void shouldNotFindPost() {
        Post notExistingPost = new Post();
        notExistingPost.setId(0L);
        notExistingPost.setTitle("modified");
        notExistingPost.setBody("modified");

        assertEquals("There is no post with ID 0", postController.updatePost(notExistingPost));
    }
}