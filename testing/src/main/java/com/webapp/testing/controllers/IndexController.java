package com.webapp.testing.controllers;

import com.webapp.testing.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${text.indexcontroller.index.title}")
    private String textIndex;
    @Value("${text.indexcontroller.profile.title}")
    private String textProfile;
    @Value("${text.indexcontroller.list.title}")
    private String textList;
    @Value("${text.indexcontroller.text.title}")
    private String onlyText;
    @GetMapping({"/index", "/"})
    public String index(Model model){
        model.addAttribute("index", textIndex);
        model.addAttribute("text",onlyText);
        return "index";
    }

    @RequestMapping("/profile")
    public String profile(Model model){
        User User = new User();
        User.setFirstName("Diego");
        User.setLastName("Escobedo");
        User.setEmail("diego.esc.cab@gmail.com");

        model.addAttribute("user",User);
        model.addAttribute("title", "Perfil del Usuario: ".concat(User.getFirstName()));

        return "profile";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("title", textList);
        //model.addAttribute("users",Users);

        return  "list";
    }

    @ModelAttribute("users")
    public  List<User> poblation(){
        List<User> Users = new ArrayList<>();
        Users.add(new User("Diego","Escobedo","diego.esc.cab@gmail.com"));
        Users.add(new User("Dieguito","Escobedo","diego@gmail.com"));
        Users.add(new User("Diego","Cabrera","esc.cab@gmail.com"));

        return Users;
    }
}
