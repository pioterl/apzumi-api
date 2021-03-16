package com.apzumi.apzumiapi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Posts {

    public int userId;
    @Id
    public Long id;
    public String title;
    public String body;
}
