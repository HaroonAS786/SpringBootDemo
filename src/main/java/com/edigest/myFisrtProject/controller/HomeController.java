package com.edigest.myFisrtProject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/hello")
    public String index() {
        String response = getViewName();
        System.out.println("AppName: " + appName);
        return response;
    }

    public String getViewName() {
        return "index.html";
    }

}
