package com.example.form_dang_ky.controller;

import com.example.form_dang_ky.entity.User;
import com.example.form_dang_ky.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("user",new User());
        return "/user/create";
    }
    @GetMapping("/list")
    public String display(Model model){
        model.addAttribute("user",iUserService.findAll());
        return "/user/list";
    }
    @PostMapping("/create")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if ((bindingResult.hasErrors())){
            return new ModelAndView("/user/create");
        }

        iUserService.save(user);
        return new ModelAndView("redirect:/user/list");
    }
}
