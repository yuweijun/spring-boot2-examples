package com.example.jpa.controller;

import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Weijun Yu
 * @since 2019-09-05.
 */
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String index() {
    // test session flush and update in JTA
    userService.update();
    return "index";
  }

}
