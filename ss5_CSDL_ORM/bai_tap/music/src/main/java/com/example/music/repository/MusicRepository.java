package com.example.music.repository;

import com.example.music.entity.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class MusicRepository implements IMusicRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void create(Music music) {
        entityManager.persist(music);
    }
    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void delete(Music music) {
        entityManager.remove(entityManager.merge(music));
    }

    @Override
    public Music findById(String id) {
        return entityManager.find(Music.class,id);
    }

    @Override
    public List<Music> findByName(String tenBaiHat) {
        String keySearch = new StringBuilder().append("%").append(tenBaiHat).append("%").toString();
        return entityManager.createQuery("select m from Music m where m.tenBaiHat like ?1",Music.class).setParameter(1,keySearch).getResultList();
    }

    @Override
    public List<Music> getAll() {
        return entityManager.createQuery("select m from Music m").getResultList();
    }
}
