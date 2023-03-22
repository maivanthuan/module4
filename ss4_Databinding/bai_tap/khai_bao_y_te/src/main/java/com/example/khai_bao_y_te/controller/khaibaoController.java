package com.example.khai_bao_y_te.controller;

import com.example.khai_bao_y_te.model.KhaiBao;
import com.example.khai_bao_y_te.repository.IKhaiBaoRepository;
import com.example.khai_bao_y_te.repository.KhaiBaoRepsitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/khaibao")
public class khaibaoController {
    private IKhaiBaoRepository iKhaiBaoRepository=new KhaiBaoRepsitory();
    @GetMapping("/create")
    public String showcreate(Model model){
        KhaiBao khaiBao=new KhaiBao();
        String[] gioitinh=new String[] {"nam","nu","khac"};
        String[] quoctich=new String[] {"viet nam","lao" ,"campuchia","thai lan"};
        String[] thongtindilai=new String[] {"may bay","thuyen","oto","moto"};
        String[] ykien= new String[] {"co","khong"};
        model.addAttribute("khaibao",khaiBao);
        model.addAttribute("gioiTinh",gioitinh);
        model.addAttribute("quocTich",quoctich);
        model.addAttribute("thongTinDiLai",thongtindilai);
        model.addAttribute("yKien",ykien);
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "khaibao") KhaiBao khaiBao){
        iKhaiBaoRepository.create(khaiBao);
        return "redirect:/khaibao/list";
    }
    @GetMapping(value = "/list")
    public String display(Model model){
        model.addAttribute("khaiBao",iKhaiBaoRepository.findAll());
        return "list";
    }
}
