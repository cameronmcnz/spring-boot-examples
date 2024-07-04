package com.mcnz.rps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController("")
public class GameSummaryController {
	
	static List<GameSummary> history = new ArrayList<GameSummary>();
	
	@GetMapping("/gamesummary")
	public List<GameSummary> getHistory() {
		return history;
	}
	
	
	@GetMapping("gamesummary/{id}")
	public GameSummary getGameSummary(@PathVariable int id) {
		return history.get(id);
	}
	
	@PostMapping("/gamesummary")
	public GameSummary addGameSummary(@RequestBody GameSummary gameSummary) {
		history.add(gameSummary);
		return gameSummary;
	}
	
	
	
	

}
