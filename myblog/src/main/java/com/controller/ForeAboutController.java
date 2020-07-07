package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForeAboutController {

    @GetMapping("/about")
    public String toAboutPage(){
        return "about";
    }
}
