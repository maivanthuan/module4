package com.example.muon_sach.service;

import com.example.muon_sach.entity.Book;
import com.example.muon_sach.entity.Code;
import com.example.muon_sach.repository.BookRepository;
import com.example.muon_sach.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodeService implements ICodeService{
    @Autowired
    CodeRepository codeRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Code> findAll() {
        return codeRepository.findAll();
    }

    @Override
    public Code findById(Integer id) {
        return codeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public void delete(Integer id) {
        Code code=codeRepository.findById(id).orElse(null);
        Book book=bookRepository.findById(code.getBook().getId()).orElse(null);
        book.setQuantity(book.getQuantity()-1);
        codeRepository.deleteById(id);
        bookRepository.save(book);
    }

    @Override
    public List<Code> findAllCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_Id(id);
    }

    @Override
    public List<Code> findAvailableCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id,1);
    }

    @Override
    public List<Code> findUsedCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id,2);
    }

    @Override
    public void returnBookByCode(Book book, Integer returnCode) {
    }
}
