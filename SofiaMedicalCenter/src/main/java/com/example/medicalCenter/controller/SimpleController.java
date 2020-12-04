package com.example.medicalCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicalCenter.service.GeneticTestService;

@RestController
public class SimpleController {
 
	@Autowired
	GeneticTestService geneticTestService;
	
    @RequestMapping("/")
    public String homePage(Model model) {
        return "spring is working";
    }
}