package com.webapp.testing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariableControllerTest {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Sending variables from the path (@PathVariable)");
        return "variables/index";
    }
    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model) {
        model.addAttribute("title", "Receiving variables from the path (@PathVariable)");
        model.addAttribute("result", "The submitted text in the URL is: " + text);
        return "variables/see";
    }

    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable Integer number, Model model) {
        model.addAttribute("title", "Receiving variables from the path (@PathVariable)");
        model.addAttribute("result", "The submitted text in the URL is: " + text
                + " and the number submitted from the path is: " + number);
        return "variables/see";
    }
}
