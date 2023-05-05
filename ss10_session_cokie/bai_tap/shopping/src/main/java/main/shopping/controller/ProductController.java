package main.shopping.controller;

import main.shopping.entity.Product;
import main.shopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
@Autowired
    IProductService iProductService;
@GetMapping("view")
    public String viewProduct(Model model){
    model.addAttribute("products",iProductService.findAll());
    return "/view-products";
}
@GetMapping("check")
    public String checkProduct(@RequestParam("id")Integer id, Model model){
    Product product=iProductService.findById(id);
    model.addAttribute("products",product);
    return "check-products";
}
}
