package com.example.blog.controller;

import com.example.blog.Model.Blog;
import com.example.blog.Model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showBlogList (@RequestParam(required = false, defaultValue = "") String name, Model model,
                                @PageableDefault(size = 5) Pageable pageable) {
        if (name == null) {
            name = "";
        }

        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Blog> blogPage = blogService.findAll(name, sortedPageable);

        model.addAttribute("blogList", blogPage);
        model.addAttribute("name", name);

        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= blogPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }

        model.addAttribute("pageNumberList", pageNumberList);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm (@RequestParam (required = false) String name,Model model,
                                  @PageableDefault Pageable pageable) {
        if (name == null) {
            name = "";
        }
        model.addAttribute("categoryList", categoryService.findAll(name, pageable));
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate (@ModelAttribute Blog blog) {
        blogService.createBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showBlogDetail (@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "/detail";
    }

    @GetMapping("/delete")
    public String performDelete (@RequestParam Integer deleteId) {
        blogService.deleteBlog(deleteId);
        return "redirect:/blog";
    }

    @GetMapping("/edit")
    public String showUpdateForm (@RequestParam (required = false) Integer id, String name, Model model,
                                  @PageableDefault Pageable pageable) {
        if (name == null) {
            name = "";
        }
        model.addAttribute("categoryList", categoryService.findAll(name, pageable));
        model.addAttribute("blog", blogService.findBlogById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String performUpdate (@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/blog";
    }
}
