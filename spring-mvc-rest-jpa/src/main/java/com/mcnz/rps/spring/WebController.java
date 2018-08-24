package com.mcnz.rps.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {

	@GetMapping("/playagame")
	public String playRoshambo(@RequestParam(name = "choice", required=false) String choice, Model model) {
		System.out.println("In play");
		if (choice == null) {
			return "index";
		}
		System.out.println("Choice: " + choice);

		GameSummary gameSummary = new GameSummary();
		gameSummary.clientGesture = Gesture.valueOf(choice.toUpperCase());
		gameSummary.serverGesture = Gesture.ROCK;

		String result = "tie";
		if (gameSummary.clientGesture.equals(Gesture.PAPER)) {
			result = "win";
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject("http://localhost:8080/score/wins", "", Object.class);
		}
		if (gameSummary.clientGesture.equals(Gesture.SCISSORS)) {
			result = "lose";
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject("http://localhost:8080/score/losses", "", Object.class);
		}
		if (result == "tie") {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject("http://localhost:8080/score/ties", "", Object.class);
		}
		gameSummary.setResult(result);

		RestTemplate restTemplate = new RestTemplate();
		Score score = restTemplate.getForObject("http://localhost:8080/score", Score.class);

		model.addAttribute("gameSummary", gameSummary);
		model.addAttribute("score", score);
		// request.getRequestDispatcher("index.jsp").forward(request, response);

		return "results";
	}
	
	@GetMapping("/index")
	public String index(@RequestParam(name = "choice", required=false) String choice, Model model) {
		return "index";
	}
	
	

}
