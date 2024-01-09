package com.oidc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Sample {
    @RequestMapping("/")
    public String greeting(){
        return "sample!!";
    }
}
