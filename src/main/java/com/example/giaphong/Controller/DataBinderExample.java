package com.example.giaphong.Controller;

import com.example.giaphong.DTO.SimpleUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DataBinderExample {

    @GetMapping("/")
    public String dataBinding(SimpleUser simpleUser) {

        return "DemoBindingData";
    }

    @PostMapping("/")
    public String create(Model model, @Valid SimpleUser user,
                         BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "DemoBindingData";
        }

        return "Result";
    }


}
