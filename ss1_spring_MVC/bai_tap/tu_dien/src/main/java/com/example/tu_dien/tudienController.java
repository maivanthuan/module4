package com.example.tu_dien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class tu_dien {
    @GetMapping("/tudien")
    public String tudien(){
                return "index";
    }
    public String tudiendatim(@RequestParam String input, Model model){
        Map<String,String> tu_dien=new HashMap<>();
        tu_dien.put("dog","chó");
        tu_dien.put("cat","mèo");
        tu_dien.put("hello","xin chào");
        tu_dien.put("bye","Bái bai");
        String search=tu_dien.get(input);
        if (search==null){
            search="not found";
        }else {
            search=tu_dien.get(input);
        }
        model.addAttribute("result",search);
        return "index";
    }
}
