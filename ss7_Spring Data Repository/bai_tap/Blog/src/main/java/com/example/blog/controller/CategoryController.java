package com.example.blog.controller;

import com.example.blog.entity.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("category",iCategoryService.findAll());
        return "/category/list_category";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        Category category=new Category();
        model.addAttribute("category",category);
        return "/category/create_category";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "category") Category category){
        iCategoryService.addNew(category);
        return "redirect:/category/list";
    }
}
