package com.apzumi.apzumiapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    public Long id;
    public String title;
    public String body;
}
