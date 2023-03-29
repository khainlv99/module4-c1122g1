package com.codegym.cotroller;

import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("index")
public class Caculator {

    private final ICaculatorService iCaculatorService;

    public Caculator(ICaculatorService iCaculatorService) {
        this.iCaculatorService = iCaculatorService;
    }

    @GetMapping
    public String showCaculator(){
        return "list";
    }
    @PostMapping
    public String calculate(
            @RequestParam (name ="numberOne") double numberOne,
            @RequestParam (name ="numberTwo") double numberTwo,
            @RequestParam (name ="calculate") String calculate,
            Model model
    ){
        model.addAttribute("result", iCaculatorService.caculator(calculate,numberOne,numberTwo));
        return "list";
    }
}
