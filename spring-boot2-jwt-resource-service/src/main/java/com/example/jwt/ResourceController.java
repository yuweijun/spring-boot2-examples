package com.example.jwt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResourceController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";

    @GetMapping("/")
    public String home() {
        return "redirect:/resource";
    }

    @GetMapping("/resource")
    public String resource(HttpServletRequest request, Model model) {
        // Object username = request.getAttribute("username");
        // System.out.println("username " + username);
        // model.addAttribute("username", "test");
        return "resource";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
    }
}
