package com.example.music.repository;

import com.example.music.entity.Music;

import java.util.List;

public interface IMusicRepository {
    void create(Music music);
    void update(Music music);
    void delete(Music music);
    Music findById(String id);
    List<Music>findByName(String tenBaiHat);
    List<Music>getAll();
}
