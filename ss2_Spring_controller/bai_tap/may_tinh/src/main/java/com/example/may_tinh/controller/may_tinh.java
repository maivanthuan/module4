package com.example.may_tinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class may_tinh {
    @GetMapping("/maytinh")
    public String display(){
        return "index";
    }
    @GetMapping("/calculation")
    public String calcula(@RequestParam("operator") String operator, Model model, @RequestParam("num1") int num1, @RequestParam("num2") int num2){
        int result=0;
        switch (operator) {
            case "Addition(+)":
                result = num1 + num2;
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                break;
            case "Multiplication(x)":
                result = num1 * num2;
                break;
            case "Division(/)":
                result = num1 / num2;
                break;
        }
        model.addAttribute("result",result);
        return "index";
    }
}
