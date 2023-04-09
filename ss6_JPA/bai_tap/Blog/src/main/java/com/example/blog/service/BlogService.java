package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public interface BlogService {
  Page<Blog> findAll(Pageable pageable);
  Blog findById(Long id);
  void save(Blog blog);
  void remove(Long id);
  List<Blog> findByContent(String content);
}
