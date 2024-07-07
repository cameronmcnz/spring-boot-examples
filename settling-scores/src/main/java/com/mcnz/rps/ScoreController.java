package com.mcnz.rps;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ScoreController {
	
	static Score score = new Score(30, 20, 10);
	
	@PatchMapping("/score/wins")
	public Score setWins(@RequestParam(name="new-value") int newValue) {
		score.wins = newValue;
		return score;
	}
	
	@GetMapping("/score/health-check")
	public String healthCheck() {
		return "Situation normal everything fine";
	}
	
	@GetMapping("/score")
	public Score getScore() {
		if (score == null) {
			score = new Score();
		}
		return score;
	}
	
	@PostMapping("/score/wins")
	public Score increaseWins() {
		score.wins++;
		return score;
	}
	
	@PostMapping("/score/losses")
	public Score increaseLosses() {
		score.losses++;
		return score;
	}
	
	@PostMapping("/score/ties")
	public Score increaseTies() {
		score.ties++;
		return score;
	}
	
	@PutMapping("/score")
	public Score setScore(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}
	
	
	@DeleteMapping("/score")
	public void deleteScore() {
		score = null;
	}
	
	@GetMapping("/score/{winsLossesOrTies}")
	public int getWinsLossesOrTies(@PathVariable String winsLossesOrTies) {
		int valueToReturn;
		if (winsLossesOrTies.equalsIgnoreCase("wins")) {
			valueToReturn = score.wins;
		} else if (winsLossesOrTies.equalsIgnoreCase("losses")){
			valueToReturn = score.losses;
		} else {
			valueToReturn = score.ties;
		}
		return valueToReturn;
	}

}
