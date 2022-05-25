package com.example.springbootinitializr.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class GreetingService {
    public String getGreetingMessage(String[] names){
        List<String> upperCaseNames = new ArrayList<>();
        List<String> lowerCaseNames = new ArrayList<>();
        for (int i = 0; i < names.length-1; i++) {
            if (names[i].equals(names[i].toUpperCase(Locale.ROOT))) {
                upperCaseNames.add(names[i]);
                continue;
            }
            lowerCaseNames.add(names[i]);
        }

        var lowerCaseGreetingMessage = getGreetingMessageForMultipleNames(lowerCaseNames);
        var upperCaseGreetingMessage = getGreetingMessageForMultipleNames(upperCaseNames);

        if(lowerCaseGreetingMessage.isEmpty()){
            return "HELLO, " + upperCaseGreetingMessage.toUpperCase(Locale.ROOT) + ".";
        }

        if(upperCaseGreetingMessage.isEmpty()){
            return "Hello, " + lowerCaseGreetingMessage + ".";
        }

        return "Hello, " + lowerCaseGreetingMessage + ". AND HELLO, "
                + upperCaseGreetingMessage.toUpperCase(Locale.ROOT) + ".";

    }

    private String getGreetingMessageForMultipleNames(List<String> names) {
        if (names.size() == 1) return names.get(0);

        var namesWithoutLastOne = names.subList(0, names.size()-1);
        var result = String.join(", ", namesWithoutLastOne);

        return result + " and " + names.get(names.size()-1);
    }

}
