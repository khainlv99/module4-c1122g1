package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
public class ProductController {
    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("list", iProductService.findAll());
        return "/list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("list",new Product());
        return "/create";
    }
    @PostMapping("create")
    public String create(Product product
            ){
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("update/{id}")
    public String showUpdate(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "/update";
    }
    @PostMapping("update")
    public String update(Product product){
        iProductService.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        iProductService.remote(id);
        return "redirect:/product";
    }
    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("list", iProductService.findById(id));
        return "/detail";
    }

}
