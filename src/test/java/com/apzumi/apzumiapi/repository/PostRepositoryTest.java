package com.apzumi.apzumiapi.repository;

import com.apzumi.apzumiapi.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void shouldBeEmpty() {
        assertThat(postRepository.findAll()).isEmpty();
    }

    @Test
    void shouldSavePost() {
        Post post = new Post(1, 1L, "tytuł", "treść");
        postRepository.save(post);

        assertThat(postRepository.findById(1L)).isNotEmpty();
    }

}