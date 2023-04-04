package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping()
    public String listBlog(Model model){
        model.addAttribute("list",blogService.getAll());
        return "/list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("list", new Blog());
        return "/create";
    }
    @PostMapping("create")
    public String create(Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model){
        model.addAttribute("list",blogService.getStudentById(id));
        return "/update";
    }

    @PostMapping("update")
    public String update(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("list", blogService.getStudentById(id));
        return "/detail";
    }
}
