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
        Post existingPost = new Post(1, 2L, "modified", "modified");

        assertThat(postController.updatePost(existingPost)).isEqualTo("Updating post with ID 2");
    }

    @Test
    void shouldNotFindPostToUpdate() {
        Post notExistingPost = new Post(1, 0L, "modified", "modified");

        assertThat(postController.updatePost(notExistingPost)).isEqualTo("There is no post with ID 0");
    }

    @Test
    void shouldFindPostByString() {
        assertThat(postController.search("facere")).isNotEmpty();
    }

    @Test
    void shouldNotBeEmpty() {
        assertThat(postController.list()).isNotEmpty();
    }
}