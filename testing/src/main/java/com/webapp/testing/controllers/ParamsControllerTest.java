package com.webapp.testing.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.NumberFormat;

@Controller
@RequestMapping("/params")
public class ParamsControllerTest {

    @GetMapping("/")
    public  String index(){
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "text", required = false, defaultValue = "...") String text, Model model){
        model.addAttribute("result","Sent message was: " + text);

        return "params/see";
    }
    @GetMapping("/mix-params")
    public String param(@RequestParam String hi, @RequestParam Integer number, Model model){
        model.addAttribute("result","Sent message was: " + hi + " and the number is: " + number);


        return "params/see";
    }
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String hi = request.getParameter("hi");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e){
            number = 0;
        }

        model.addAttribute("result","Sent message was: " + hi + " and the number is: " + number);


        return "params/see";
    }

}
