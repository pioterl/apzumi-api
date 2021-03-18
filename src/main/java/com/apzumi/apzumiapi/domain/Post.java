package com.apzumi.apzumiapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public int userId;

    @Id
    public Long id;
    public String title;
    public String body;
}
