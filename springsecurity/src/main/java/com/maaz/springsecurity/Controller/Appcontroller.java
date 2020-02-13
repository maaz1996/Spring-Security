package com.maaz.springsecurity.Controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Appcontroller {

    @GetMapping("/developer/weather")
    public String developer() {
        return "Sunny and Hot in this Winter";
    }

    @GetMapping("/consultant/weather")
    public String consultant() {
        return "Cold in this Winter";
    }

    @GetMapping("/director/weather")
    public String director() {
        return "Is it even Winter?";
    }

}
