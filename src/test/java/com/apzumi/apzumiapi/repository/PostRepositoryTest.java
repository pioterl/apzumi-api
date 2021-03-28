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

    @Test
    void shouldFindAllPost() {
        Post post1 = new Post(1, 1L, "tytuł1", "treść1");
        postRepository.save(post1);

        Post post2 = new Post(1, 2L, "tytuł2", "treść2");
        postRepository.save(post2);

        Post post3 = new Post(1, 3L, "tytuł3", "treść3");
        postRepository.save(post3);

        Iterable<Post> posts = postRepository.findAll();

        assertThat(posts).hasSize(3).contains(post1, post2, post3);
    }

}