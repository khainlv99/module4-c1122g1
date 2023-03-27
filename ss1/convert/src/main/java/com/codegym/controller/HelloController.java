package com.codegym.controller;

import com.codegym.service.impl.ConvertService;
import com.codegym.service.IConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    private IConvertService iConvertService = new ConvertService();
    @GetMapping("student")
    public String showFormCal() {
        return "list";
    }

    @GetMapping("student/result")
    public String user(@RequestParam(name = "usa") double usa, Model model) {
        model.addAttribute("usa1", iConvertService.convert(usa));
        return "list";
    }
}
