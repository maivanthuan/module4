package com.example.khai_bao_y_te.repository;

import com.example.khai_bao_y_te.model.KhaiBao;

import java.util.ArrayList;
import java.util.List;

public class KhaiBaoRepsitory implements IKhaiBaoRepository{
    private List<KhaiBao> khaiBaoList=new ArrayList<>();
    @Override
    public void create(KhaiBao khaiBao) {
        khaiBaoList.add(khaiBao);
    }

    @Override
    public List<KhaiBao> findAll() {
        return khaiBaoList;
    }
}
