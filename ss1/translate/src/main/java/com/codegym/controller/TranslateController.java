package com.codegym.controller;

import com.codegym.service.ITranslateService;
import com.codegym.service.impl.TranslateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("student")
public class TranslateController {
    private ITranslateService iTranslateService = new TranslateService();


    @GetMapping("")
    public String showFormCal() {
        return "list";
    }

    @PostMapping("")
    public String user(@RequestParam(name = "english") String english ,Model model) {
        model.addAttribute("result", iTranslateService.translate(english));
        return "list";
    }
}
