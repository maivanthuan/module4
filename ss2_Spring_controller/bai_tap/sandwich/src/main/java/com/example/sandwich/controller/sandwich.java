package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sandwich {
    @GetMapping("/sandwich")
    public String display(){
        return "index";
    }
    @GetMapping("/condiment")
    public String condiment(@RequestParam ("condiment") String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "list";
    }
}
