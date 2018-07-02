package com.mcnz.rps.smvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {
	
	@GetMapping("/playagame")
	public String playRoshambo(@RequestParam(name = "choice", required=false) String choice, Model model) {
		
		if (choice == null) {
			return "index";
		}

		return "results";
	}
	

}
