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
public class HelloController {
    private ITranslateService iTranslateService = new TranslateService();


    @GetMapping("")
    public String showFormCal() {
        return "list";
    }

    @PostMapping("")
    public String user(@RequestParam(name = "english") String english ,Model model) {
//        String name1 = null;
//        String name2 = null;
//        switch (string1){
//            case "Mot":
//                name1 = "One";
//                break;
//            case "Hai":
//                name1 = "Two";
//                break;
//            case "Ba":
//                name1 = "Three";
//                break;
//        }
//        switch (string2){
//            case "One":
//                name2 = "Một";
//                break;
//            case "Two":
//                name2 = "Hai";
//                break;
//            case "Three":
//                name2 = "Ba";
//                break;
//        }
//        model.addAttribute("name", name1);
//        model.addAttribute("name2", name2);
//        return "list";

        model.addAttribute("result", iTranslateService.translate(english));
        return "list";
    }
}
