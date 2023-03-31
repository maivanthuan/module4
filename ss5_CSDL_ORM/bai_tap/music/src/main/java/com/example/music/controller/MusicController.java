package com.example.music.controller;

import com.example.music.entity.Music;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class MusicController {
    @Autowired
    IMusicService iMusicService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("listMusic",iMusicService.getAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }
    @PostMapping ("/create")
    public String doCreate(@ModelAttribute("music")Music music, RedirectAttributes rd){
        iMusicService.create(music);
        rd.addFlashAttribute("message","them moi thanh cong");
        return "redirect:/list";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id")String id,Model model){
        model.addAttribute("music",iMusicService.finById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("music")Music music){
        iMusicService.update(music);
        return "redirect:/list";
    }
    @GetMapping("/remove/{id}")
    public String doDelete(@PathVariable("id")String id){
        Music music=iMusicService.finById(id);
        iMusicService.delete(music);
        return "redirect:/list";
    }
    @GetMapping("/search")
    public String   searchName(@RequestParam("inputSearch") String inputSearch, Model model){
        model.addAttribute("listMusic",iMusicService.findByName(inputSearch));
        return "/list";
    }
}
