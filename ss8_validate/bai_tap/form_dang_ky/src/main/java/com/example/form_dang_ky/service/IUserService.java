package com.example.form_dang_ky.service;

import com.example.form_dang_ky.entity.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    List<User>findAll();

}
