package com.apzumi.apzumiapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    public int userId;
    @Id
    public Long id;
    public String title;
    public String body;
}
