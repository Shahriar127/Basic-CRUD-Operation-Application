package com.shahriar.demo2.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTestController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("appName", "Spring Boot");
        return "index";
    }
}
