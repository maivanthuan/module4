package com.example.khai_bao_y_te.repository;

import com.example.khai_bao_y_te.model.KhaiBao;

import java.util.List;

public interface IKhaiBaoRepository {
    void create(KhaiBao khaiBao);
    List<KhaiBao> findAll();
}
