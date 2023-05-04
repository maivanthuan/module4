package com.example.muon_sach.service;

import com.example.muon_sach.entity.Book;
import com.example.muon_sach.entity.Code;

import javax.validation.Valid;
import java.util.List;

public interface IBookService  {
    List<Book>findAll();
    void save(Book book);
    void delete(Book book);
    void borrow(Book book,Integer usedCode);
    void returnBook(Book book, Integer returnCode);
    Book findById(Integer id);
    Code getNextAvailableCode(Book book);
}
