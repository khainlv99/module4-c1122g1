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
    final
    IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("list")
    public String displayList(Model model) {
        model.addAttribute("listProduct", iProductService.findAll());
        return "list";
    }

    @PostMapping("delete")
    public String deleteByIDs(@RequestParam("idProduct") int id) {
        iProductService.deleteByID(id);
        return "redirect:/product/list";
    }

    @GetMapping("create")
    public String formCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("create")
    public String create(Product product) {
        iProductService.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("detail/{id}")
    public String search(@PathVariable String name, Model model) {
        model.addAttribute("product", iProductService.searchByName(name));
        return "/detail";
    }

    @GetMapping("search")
    public String searchByName(@RequestParam("nameProduct") String name, Model model) {
        model.addAttribute("listProduct", iProductService.searchByName(name));
        return "/list";
    }

    @PostMapping("edit")
    public String edit(Product product) {
        iProductService.edit(product);
        return "redirect:/product/list";
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", iProductService.findByID(id));
        return "/edit";
    }

}
