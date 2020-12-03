package com.example.medicalCenter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
 
    @RequestMapping("/")
    public String homePage(Model model) {
        return "spring is working";
    }
}