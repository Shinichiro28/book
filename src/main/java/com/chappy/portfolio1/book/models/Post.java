package com.chappy.portfolio1.book.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 254)
    private String introduction;
}
