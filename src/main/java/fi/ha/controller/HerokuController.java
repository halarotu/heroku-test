package fi.ha.controller;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HerokuController {
	
	private final String MYCOOKIE = "myCookie"; 
	
	@RequestMapping("/")
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        
		String cookie = "";
		if (request.getCookies() != null) {
			for (Cookie c : Arrays.asList(request.getCookies())) {
				if (c.getName().equals(MYCOOKIE)) {
					cookie = c.getValue();
					break;
				}
			}
		}

		int counter = 0;
        if (cookie != null && !cookie.isEmpty()) {
        	try {
        		counter = Integer.parseInt(cookie);
        		counter++;
        	} catch (Exception e) {
        		counter = 0;
        	}
        }

		response.addCookie(new Cookie(MYCOOKIE, ""+counter));
		model.addAttribute("counter", ""+counter);
		model.addAttribute("header", "My Spring Boot Test App");
		
		return "index";
    }

}
