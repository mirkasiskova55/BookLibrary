package com.example.BookLibrary.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    public String  createInsurance(){
        return "testdopice";
    }
}
