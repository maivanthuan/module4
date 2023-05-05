package main.shopping.controller;

import main.shopping.entity.Cart;
import main.shopping.entity.Product;
import main.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("shopping-cart")
@SessionAttributes("cart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }
    @GetMapping("view")
    public String viewCart(@ModelAttribute("cart")Cart cart, Model model){
        model.addAttribute("cartItems",cart.getCartItems());
        model.addAttribute("totalPrices",cart.getTotalPrice());
        return "shopping_cart";
    }
    @GetMapping("/add")
    public String addCart(@RequestParam("id") Integer id,@ModelAttribute("cart") Cart cart,Model model){
        Product product=productService.findById(id);
        if (product!=null){
            cart.addItem(product);
        }else {
            return "error.404";
        }
        model.addAttribute("cart",cart);
        return "redirect:/shopping-cart/view";
    }
    @GetMapping("remove")
    public String removeCart(@RequestParam("id") Integer id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.removeItem(product);
        } else {
            return "error.404";
        }
        return "redirect:/shopping-cart/view";
    }
    @GetMapping("payment")
    public String payment(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("totalPrice", cart.getTotalPrice());
        cart.clearCart();
        return "payment";
    }
    @PostMapping("update")
    public String updateCart(@RequestParam("id") Integer id,
                             @RequestParam("quantity") Integer newQuantity,
                             @ModelAttribute("cart") Cart cart,
                             Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.updateItem(product, newQuantity);
        } else {
            return "error.404";
        }
        model.addAttribute("cart", cart);
        return "redirect:/shopping-cart/view";
    }
}
