package com.codegym.controller;

import com.codegym.model.Settings;
import com.codegym.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class SettingController {
    private final ISettingsService service;

    public SettingController(ISettingsService service) {
        this.service = service;
    }

    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("settings", new Settings());
        Settings settings = new Settings();
        model.addAttribute("filter",settings);
        return "create";
    }
    @PostMapping("create")
    public String create(
            @ModelAttribute Settings settings,
            BindingResult result,
            Model model
            ){
        model.addAttribute("mailBox", new Settings());
        model.addAttribute("languages", service.languages());
        model.addAttribute("pageSizes", service.pageSizes());
        model.addAttribute("settings",settings);
        return "index";
    }
}
