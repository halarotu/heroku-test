package fi.ha.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HerokuController {
	
	@RequestMapping("/")
    public String home(Model model, HttpServletResponse response, @CookieValue("myCookie") String cookie) {
        int counter = 0;
        if (cookie != null) {
        	try {
        		counter = Integer.parseInt(cookie);
        		counter++;
        	} catch (Exception e) {
        		counter = 0;
        	}
        }

		response.addCookie(new Cookie("myCookie", ""+counter));
		model.addAttribute("counter", ""+counter);
		model.addAttribute("header", "My Spring Boot Test App");
		
		return "index";
    }

}
