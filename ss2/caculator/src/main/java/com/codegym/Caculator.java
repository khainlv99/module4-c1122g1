package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("index")
public class Caculator {

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
        double result = 0.0;
        switch (calculate){
            case "Addition(+)":
                result = numberOne + numberTwo;
                break;
            case "Subtraction(-)":
                result = numberOne - numberTwo;
                break;
            case "Multiplication(X)":
                result = numberOne * numberTwo;
                break;
            case "Division(/)":
                if (numberTwo == 0){
                    model.addAttribute("msg","Không thể chia cho 0");
                    break;
                }
                result = numberOne / numberTwo;
                break;
        }
        model.addAttribute("result", result);
        return "list";
    }
}
