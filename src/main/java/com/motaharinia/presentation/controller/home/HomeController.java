package com.motaharinia.presentation.controller.home;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping("/")
    public String home() {
        return "Hello Homepage Spring Data JPA with MongoDB!";
    }


}
