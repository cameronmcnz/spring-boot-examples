package com.mcnz.rps.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ScoreService {
	
	static Score score = new Score();
	
	@GetMapping("/score/increasewins")
	public Score increaseWins() {
		score.wins = score.wins + 1;
		return score;
		
	}
	
	@GetMapping("/score/increaselosses")
	public Score increaseLosses() {
		score.losses = score.losses + 1;
		return score;
		
	}
	
	@GetMapping("/score/increaseties")
	public Score increaseTies() {
		score.wins = score.ties + 1;
		return score;
	}
	
	@GetMapping("/score")
	public Score getScore() {
		return score;
	}
}
