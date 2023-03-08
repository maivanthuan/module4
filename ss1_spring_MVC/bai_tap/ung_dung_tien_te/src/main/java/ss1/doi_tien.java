import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class doi_tien {
    @GetMapping("/tiente")
    public String doi_tien(){
        return "index";
    }
    @GetMapping("/tiendadoi")
    public String da_doi(@RequestParam float usd,Model model){
        float change=usd * 23000;
        model.addAttribute("change",change);
        return "index";
    }

}
