package fi.ha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HerokuController {
	
	@RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("teksti", "My Spring Boot Test App");
		return "index";
    }

}
