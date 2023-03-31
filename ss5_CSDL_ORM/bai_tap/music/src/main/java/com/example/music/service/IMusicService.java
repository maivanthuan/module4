package com.example.music.service;

import com.example.music.entity.Music;

import java.util.List;

public interface IMusicService {
    void create(Music music);
    List<Music> findByName(String tenBaiHat);
    void update(Music music);
    void delete(Music music);
    Music finById(String id);
    List<Music> getAll();
}
