package com.example.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private static final String JWT_TOKEN_COOKIE_NAME = "JWT-TOKEN";

    private static final String SIGNING_KEY = "SIGNING_KEY";

    private static final Map<String, String> CREDENTIALS = new HashMap<String, String>() {{
        put("admin", "admin");
    }};

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(String redirect, Model model) {
        model.addAttribute("redirect", redirect);
        return "login";
    }

    @PostMapping(value = "login")
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model) {
        if (username == null || !CREDENTIALS.containsKey(username) || !CREDENTIALS.get(username).equals(password)) {
            LOGGER.error("Invalid username or password!");
            return "login";
        }

        String token = JwtUtil.generateToken(SIGNING_KEY, username);
        CookieUtil.create(httpServletResponse, JWT_TOKEN_COOKIE_NAME, token, false, -1, "localhost");

        return "redirect:" + redirect;
    }
}
