package com.codegym.controller;

import com.codegym.model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class Index {

    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("settings", new Settings());
        String[] languages = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        model.addAttribute("languages",languages);
        Integer[] pageSize = new Integer[]{5, 10, 15, 25, 50, 100};
        model.addAttribute("pageSize",pageSize);
        String[] filter = new String[]{"Enable spams filter"};
        model.addAttribute("filter",filter);
        return "create";
    }
    @PostMapping("create")
    public String create(
            @ModelAttribute Settings settings,
            BindingResult result,
            Model model
            ){
        model.addAttribute("settings",settings);
        return "index";
    }
}
