package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @PostMapping("hello")
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("English")) {
            greeting = "Hello";
        }
        else if (l.equals("portuguese")) {
            greeting = "Olá";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }

        return greeting + " " + n;
    }


    @GetMapping
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = '/hello'>" +
                "<input type = 'text' name = 'name' />" +
                "<select name= 'language'>" +
                "<option value= 'english'>English</option>" +
                "<option value= 'portuguese'>Portuguese</option>" +
                "<option value= 'spanish'>Spanish</option>" +
                "<option value= 'italian'>Italian</option>" +
                "<option value= 'french'>French</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
