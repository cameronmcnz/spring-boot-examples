package com.mcnz.rps;

import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ScoreController {
	
	static Score score = new Score(10, 5, 2);
	static {
		score.wins = 10;
	}
	
	@GetMapping("/score/wins")
	public int getWins() {
		return score.wins;
	}
	
	@GetMapping("/score/losses")
	public int getLosses() {
		return score.losses;
	}
	
	@GetMapping("/score/ties")
	public int getTies() {
		return score.ties;
	}
	
	/* curl localhost:8080/score */
	@GetMapping("/score")
	public Score getScore() {
		if (score == null) {
			score = new Score();
		}
		return score;
	}
	
	/* curl -X POST http://localhost:8080/score/wins */
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
	
	
	/* curl -X PATCH http://localhost:8080/score/wins?new-value=11 */
	@PatchMapping("/score/{winsLossesOrTie}")
	public Score setTies(@PathVariable String winsLossesOrTie, @RequestParam(name="new-value") int newValue) {
		
		if (winsLossesOrTie.equalsIgnoreCase("wins")) {
			score.wins = newValue;
		} else if (winsLossesOrTie.equalsIgnoreCase("losses")) {
			score.losses = newValue;
		} else {
			score.ties = newValue;
		}
		return score;
	}
	
	
	/* curl -d '{"wins":11, "losses":6, "ties":33}' -H "Content-Type: application/json" -X PUT http://localhost:8080/score */
	@PutMapping("/score")
	public Score reset(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}
	
	/* curl -X DELETE http://localhost:8080/score */
	@DeleteMapping("/score")
	public void deleteScore() {
		score = null;
	}

}
