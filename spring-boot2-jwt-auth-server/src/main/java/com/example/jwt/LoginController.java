package com.example.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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

        String token = generateToken(SIGNING_KEY, username);
        setCookie(httpServletResponse, JWT_TOKEN_COOKIE_NAME, token, false, -1, "localhost");

        return "redirect:" + redirect;
    }

    String generateToken(String signingKey, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                                 .setSubject(subject)
                                 .setIssuedAt(now)
                                 .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }
    void setCookie(HttpServletResponse httpServletResponse, String name, String value, Boolean secure, Integer maxAge, String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }
}
