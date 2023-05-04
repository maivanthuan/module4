package com.example.muon_sach.service;

import com.example.muon_sach.entity.Book;
import com.example.muon_sach.entity.Code;
import com.example.muon_sach.entity.Status;
import com.example.muon_sach.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ICodeService codeService;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
        Status available=new Status(1);
        for (int i=0;i<book.getQuantity();i++){
            int n=1000+new Random().nextInt(90000);
            Code code=new Code(n,bookRepository.findById(book.getId()).orElse(null),available);
            book.generateCode(code);
            codeService.save(code);
        }
    }

    @Override
    public void delete(Book book) {
    bookRepository.delete(book);
    }

    @Override
    public void borrow(Book book, Integer usedCode) {
        List<Code>codeList = codeService.findAllCodeByBookId(book.getId());
        for(Code code : codeList){
            if(code.getCode().equals(usedCode)){
                code.setStatus(new Status(2,"used"));
                break;
            }
        }
        book.borrow();
        bookRepository.save(book);
    }

    @Override
    public void returnBook(Book book, Integer returnCode) {
        List<Code> codeList = codeService.findUsedCodeByBookId(book.getId());
        for(Code code : codeList){
            if(code.getCode().equals(returnCode)){
                code.setStatus(new Status(1,"available"));
                codeService.save(code);
                book.returnBook();
                bookRepository.save(book);
                break;
            }
        }
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Code getNextAvailableCode(Book book) {
        List<Code> codeList = codeService.findAllCodeByBookId(book.getId());
        for(Code code : codeList){
            if(code.getStatus().getId() == 1){
                return code;
            }
        }
        return null;
    }
}
