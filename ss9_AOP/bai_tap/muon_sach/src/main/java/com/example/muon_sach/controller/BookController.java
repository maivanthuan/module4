package com.example.muon_sach.controller;

import com.example.muon_sach.entity.Book;
import com.example.muon_sach.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Controller
public class BookController {
    @Autowired
    BookServiceImpl bookService;
    @GetMapping("/books")
    public String listBook(Model model){
        model.addAttribute("listBook",bookService.findAll());
        return "index";
    }
    @GetMapping("/book/create")
    public String getBook(Model model){
        model.addAttribute("book",new Book());
        return "book/create";
    }
    @PostMapping("/book/create")
    public String saveBook(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
//            return"book/create";
        }
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping("/borrow/{id}")
    public String borrowForm(@PathVariable(name = "id") Integer id,Model model){
        Book book=bookService.findById(id);
        model.addAttribute("book",book);
        model.addAttribute("availableCode",bookService.getNextAvailableCode(book));
        return "book/borrow";
    }
    @PostMapping("/borrow")
    public String borrow(@Validated @ModelAttribute("book") Book book, @RequestParam Integer usedCode){
        bookService.borrow(book,usedCode);
        return "book/return";
    }
    @GetMapping("delete")
    public String delete(@RequestParam("id") Integer id){
        Book book=bookService.findById(id);
        bookService.delete(book);
        return "redirect:/index";

    }
    @PostMapping("/return")
    public String returnBook(@ModelAttribute("book") Book book,@RequestParam Integer returnCode){
        bookService.returnBook(book,returnCode);
        return "redirect:/books";
    }
}
