package com.apzumi.apzumiapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Post {

    public int userId;
    @Id
    public Long id;
    public String title;
    public String body;

    public Post() {
    }
}
