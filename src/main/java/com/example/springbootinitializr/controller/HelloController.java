package com.example.springbootinitializr.controller;

import com.example.springbootinitializr.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

@RestController
public class HelloController {
    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String getHelloString(@RequestParam(required = false) String name) {
        if (Objects.equals(name, "") || name == null) {
            return "Hello, World.";
        }

        return "Hello, " + name + ".";
    }

    @GetMapping("/hello/{name}")
    public String getHelloStringWithPathVariable(@PathVariable String name) {
        var names = name.split(",");

        return greetingService.getGreetingMessage(names);
    }
}