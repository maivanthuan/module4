package com.example.hom_dien_tu.controller;

import com.example.hom_dien_tu.model.Thudientu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("thudientu")
public class thuController {
        public String[] languages = {"english", "vietnamese", "japanese", "chinese"};
        public int[] size = {5, 10, 15, 20, 25, 50, 100};

        @GetMapping
        public String getHome(Model model) {
            Thudientu thudientu = new Thudientu();
            model.addAttribute("thudientu", thudientu);
            model.addAttribute("languages", languages);
            model.addAttribute("size", size);
            return "index";
        }
        @PostMapping
        public String save(Model model, @ModelAttribute Thudientu thudientu, RedirectAttributes rd){
            System.out.println(thudientu);
            model.addAttribute("thudientu",thudientu);
            model.addAttribute("languages",languages);
            model.addAttribute("sizes",size);
            rd.addFlashAttribute("message","Setting have been save");
            return "redirect: /thudientu";
        }
    }

