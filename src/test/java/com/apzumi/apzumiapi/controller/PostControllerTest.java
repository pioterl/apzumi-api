package com.apzumi.apzumiapi.controller;

import com.apzumi.apzumiapi.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostControllerTest {

    @Autowired
    private PostController postController;

    @Test
    void delete() {
        Long existingNumber = 1L;
        Long notExistingNumber = 101L;

        assertEquals("Deleting post with ID 1", postController.delete(existingNumber));
        assertEquals("There is no post with ID 1", postController.delete(existingNumber));
        assertEquals("There is no post with ID 101", postController.delete(notExistingNumber));
    }

    @Test
    void updatePost() {
        Post existingPost = new Post();
        existingPost.setId(2L);
        existingPost.setTitle("modified");
        existingPost.setBody("modified");

        Post notExistingPost = new Post();
        notExistingPost.setId(0L);
        notExistingPost.setTitle("modified");
        notExistingPost.setBody("modified");

        assertEquals("Updating post with ID 2", postController.updatePost(existingPost));
        assertEquals("There is no post with ID 0", postController.updatePost(notExistingPost));
    }
}