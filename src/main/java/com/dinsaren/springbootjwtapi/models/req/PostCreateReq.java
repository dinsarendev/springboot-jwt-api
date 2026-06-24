package com.dinsaren.springbootjwtapi.models.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostCreateReq {
    @NotBlank
    private String title;
    private String description;
    private String body;
    private String image;
    @NotNull
    private Integer categoryId;
    private List<String> tags = new ArrayList<>();
}