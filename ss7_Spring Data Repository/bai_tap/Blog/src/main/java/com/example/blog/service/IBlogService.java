package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    void addNew(Blog blog);
    List<Blog>findAll();
    Blog findById(int id);
    void update(Blog blog);
    void delete(Blog blog);
}
