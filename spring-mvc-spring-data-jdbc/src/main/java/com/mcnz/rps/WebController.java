package com.mcnz.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	
	@Autowired
	public ScoreRepository scoreRepo;
	
	@ResponseBody
	@GetMapping("/score")
	public Score getScore(){
		Score score;
		try {
			score = scoreRepo.findById(new Integer(1)).get();
		} catch (Exception e) {
			score = new Score(11, 22, 33);
			scoreRepo.save(score);
		}
		return score;
	}
	
	@GetMapping("/playagame")
	public String playGame(@RequestParam(name="choice")String theChoice, Model model) {
		
		String theOutcome = "tie";
		Score score = this.getScore();
		
		if (theChoice.equalsIgnoreCase("rock")) {
			score.setTies(score.getTies()+1);
			theOutcome = "tie";
		}
		if (theChoice.equalsIgnoreCase("paper")) {
			score.setWins(score.getWins()+1);
			theOutcome = "win";
		}
		if (theChoice.equalsIgnoreCase("scissors")) {
			score.setLosses(score.getLosses()+1);
			theOutcome = "loss";
		}
		scoreRepo.save(score);
		
		model.addAttribute("score", score);
		model.addAttribute("theOutcome", theOutcome);
		model.addAttribute("yourChoice", theChoice);
		return "results";
	}

}
