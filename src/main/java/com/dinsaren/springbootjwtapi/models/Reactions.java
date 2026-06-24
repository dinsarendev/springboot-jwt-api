package com.dinsaren.springbootjwtapi.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Reactions {
    @Column(name = "likes", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int likes = 0;

    @Column(name = "dislikes", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int dislikes = 0;
}