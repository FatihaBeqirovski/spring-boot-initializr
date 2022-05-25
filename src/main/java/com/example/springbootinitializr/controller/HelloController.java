package com.example.springbootinitializr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHelloString(@RequestParam(required = false) String name){
        if(Objects.equals(name, "") || name == null) {
            return "Hello, World";
        }

        return "Hello, " + name;
    }

    @GetMapping("/hello/{name}")
    public String getHelloStringWithPathVariable(@PathVariable String name) {
        var names = name.split(",");

        if (names.length == 1) {
            return getUpperCaseHello(name);
        }

        return "Hello, " + multipleNamesWithAnd(names);
    }

    private String getUpperCaseHello(String name) {
        var returnString = "Hello, " + name;

        if (name.equals(name.toUpperCase(Locale.ROOT))) {
            return returnString.toUpperCase(Locale.ROOT);
        }

        return returnString;
    }

    private String multipleNamesWithAnd(String[] names) {
        if (names.length == 1) return names[0];

        var namesWithoutLastOne = Arrays.copyOfRange(names, 0, names.length - 1);
        var result = String.join(", ", namesWithoutLastOne);

        return result + " and " + names[names.length - 1];
    }
}
