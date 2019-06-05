package com.example.jwt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ResourceController {

    private static final String JWT_TOKEN_COOKIE_NAME = "JWT-TOKEN";

    @GetMapping("/")
    public String home() {
        return "redirect:/resource";
    }

    @GetMapping("/resource")
    public String resource() {
        return "resource";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, JWT_TOKEN_COOKIE_NAME);
        return "redirect:/";
    }
}
