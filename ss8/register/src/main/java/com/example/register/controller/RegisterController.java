package com.example.register.controller;

import com.example.register.dto.RegisterDTO;
import com.example.register.model.Register;
import com.example.register.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class RegisterController {
    private final IRegisterService service;

    public RegisterController(IRegisterService service) {
        this.service = service;
    }

    @GetMapping("")
    public String findAll(Model model){
        model.addAttribute("list", service.findAll());
        return "/list";
    }

    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("listDTO",new RegisterDTO());
        return "/create";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute("listDTO") RegisterDTO registerDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            return "/create";
        }else {
            service.create(registerDTO);
            redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
            return "redirect:/register";
        }
    }
}
