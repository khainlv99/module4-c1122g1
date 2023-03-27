package com.codegym.controller;

import com.codegym.service.ChuyenDoiService;
import com.codegym.service.IChuyenDoiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    IChuyenDoiService iChuyenDoiService = new ChuyenDoiService();
    @GetMapping("student")
    public String showFormCal() {
        return "list";
    }

    @GetMapping("student/result")
    public String user(@RequestParam(name = "doLa") double doLa, Model model) {
        model.addAttribute("doLa", iChuyenDoiService.chuyenDoi(doLa));
        return "list";
    }
}
