package com.dinsaren.springbootjwtapi.services;

import com.dinsaren.springbootjwtapi.exception.AppException;
import com.dinsaren.springbootjwtapi.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll(String status, int limit, int page) throws AppException;

    List<Post> findAllByUserId(String status, int limit, int page, Integer userId,  Integer categoryId,  String name) throws AppException;

    Post findById(Integer id, String status) throws AppException;

    void save(Post post) throws AppException;

    void update(Post post) throws AppException;

    void delete(Post post) throws AppException;

}
