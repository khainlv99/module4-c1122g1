package com.codegym;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("sandwich")
public class Sandwich {

    @GetMapping("")
    public String showFormSave(){
        return "list";
    }
    @PostMapping("save")
    public String save(
            @RequestParam(required = false) String[] condiment, Model model
            ){
        if (condiment == null){
            model.addAttribute("msg","You have not selected the seasonings to go with the Sandwich");
        }
        model.addAttribute("result", condiment);
        return "save";
    }
}
