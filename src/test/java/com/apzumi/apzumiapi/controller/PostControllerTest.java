package com.apzumi.apzumiapi.controller;

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
    }
}