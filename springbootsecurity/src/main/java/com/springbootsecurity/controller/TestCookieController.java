package com.springbootsecurity.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestCookieController {

    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("color", "blue");
        response.addCookie(cookie);
        return "Cookie Header has been set";
    }

    @GetMapping("/getCookie")
    public String getCookie(@CookieValue(value = "color",
            defaultValue = "No color found in cookie") String color) {

        return "Sky is: " + color;
    }
}
