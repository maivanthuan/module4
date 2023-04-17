package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    private BlogController(IBlogService iBlogService){
        this.iBlogService=iBlogService;
    }
    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("blog",iBlogService.findAll());
        return "/blog/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",iCategoryService.findAll());
        return "/blog/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog, @RequestParam("img") MultipartFile image){
        if (image.isEmpty()){
            blog.setImage("");
        }
        Path path = Paths.get("upload/");
        try{
            InputStream inputStream = image.getInputStream();
            Files.copy(inputStream, path.resolve(image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            blog.setImage(image.getOriginalFilename().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate today = LocalDate.now();

        blog.setTime(String.valueOf(today));
        iBlogService.addNew(blog);
        return "redirect:/blog/list";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id,Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("category",iCategoryService.findAll());
        return "/blog/update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute(name = "blog") Blog blog){
        iBlogService.update(blog);
        return "redirect:/blog/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        Blog blog=iBlogService.findById(id);
        iBlogService.delete(blog);
        return "redirect:/blog/list";
    }

}
