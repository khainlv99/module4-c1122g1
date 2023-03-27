package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("student")
public class HelloController {


    @GetMapping("")
    public String showFormCal() {
        return "list";
    }

    @PostMapping("")
    public static String user(@RequestParam(name = "ten") String ten,@RequestParam(name = "ten2") String ten2 ,Model model) {
        String name1 = null;
        String name2 = null;
        switch (ten){
            case "Mot":
                name1 = "One";
                break;
            case "Hai":
                name1 = "Two";
                break;
            case "Ba":
                name1 = "Three";
                break;
        }
        switch (ten2){
            case "One":
                name2 = "Một";
                break;
            case "Two":
                name2 = "Hai";
                break;
            case "Three":
                name2 = "Ba";
                break;
        }
        model.addAttribute("name", name1);
        model.addAttribute("name2", name2);
        return "list";
    }

}
