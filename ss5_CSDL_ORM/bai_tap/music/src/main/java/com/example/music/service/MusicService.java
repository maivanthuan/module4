package com.example.music.service;

import com.example.music.entity.Music;
import com.example.music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository iMusicRepository;
    @Override
    public void create(Music music) {
        iMusicRepository.create(music);
    }
    @Override
    public List<Music> findByName(String tenBaiHat) {
        return iMusicRepository.findByName(tenBaiHat) ;
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }

    @Override
    public void delete(Music music) {
        iMusicRepository.delete(music);
    }

    @Override
    public Music finById(String id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public List<Music> getAll() {
        return iMusicRepository.getAll();
    }
}
