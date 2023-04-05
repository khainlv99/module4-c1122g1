package com.example.blog.controller;

import com.example.blog.Model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showCategoryList (@RequestParam (required = false) String name, Model model,
                                    @PageableDefault(value = 5) Pageable pageable) {
        if (name == null) {
            name = "";
        }
        model.addAttribute("categories", categoryService.listAll());
        Page<Category> categories = categoryService.findAll(name, pageable);
        model.addAttribute("categoryList", categories);
        List<Integer> pageNumberist = new ArrayList<>();
        for (int i = 1; i <= categories.getTotalPages(); i++) {
            pageNumberist.add(i);
        }

        model.addAttribute("pageNumberist", pageNumberist);
        return "category-list";
    }

    @GetMapping("/create")
    public String showCreateForm (Model model) {
        model.addAttribute("category", new Category());
        return "/category-creation";
    }

    @PostMapping("/create")
    public String performCreate (@ModelAttribute Category category) {
        categoryService.createCategory(category);
        return "redirect:/blog";
    }
}
