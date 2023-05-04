package com.example.muon_sach.repository;

import com.example.muon_sach.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {
    List<Code>findCodeByBook_Id(Integer id);
    List<Code>findCodeByBook_IdAndStatus_Id(Integer bookId,Integer statusId);
}
