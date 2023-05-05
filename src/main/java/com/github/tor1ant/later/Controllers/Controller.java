package com.github.tor1ant.later.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/test")
    public String test() {
        return "OK from controller!";
    }
}
