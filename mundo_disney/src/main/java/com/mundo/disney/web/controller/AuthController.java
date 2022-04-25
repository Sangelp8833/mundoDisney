package com.mundo.disney.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "Este es el end point para el login de usuarios";
    }

    @GetMapping("/register")
    public String resgister(){
        return "Este es el end point para el registro de usuarios";
    }
}
