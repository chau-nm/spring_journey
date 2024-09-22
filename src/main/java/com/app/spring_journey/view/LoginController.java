package com.app.spring_journey.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
  
  @RequestMapping("")
  public String view() {
    return "login";
  }

}
