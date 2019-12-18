package com.example.securitylogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yonghui
 * @since 2019. 12. 13
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
