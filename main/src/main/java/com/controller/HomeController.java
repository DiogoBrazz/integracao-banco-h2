package com.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@CrossOrigin("*")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "API está funcionando corretamente!";
    }
}
