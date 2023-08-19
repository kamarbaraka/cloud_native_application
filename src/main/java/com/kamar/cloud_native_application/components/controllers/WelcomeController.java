package com.kamar.cloud_native_application.components.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


/**
 * a controller to serve the welcome page.
 * @author kamar baraka.*/

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String  welcome(ModelMap model, @RequestBody Map<String , String> requestBody){

        model.addAttribute("name", requestBody.get("username"));

        return "welcome";
    }
}
