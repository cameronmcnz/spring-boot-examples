package com.mcnz.restful.spring.boot;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreService {
	
	private int wins, losses, ties;
	
	//{ "wins":"5", "losses":"3", "ties": "0"}
	@RequestMapping(value="/score", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getScore() {
		String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
		return String.format(pattern,  wins, losses, ties);
	
	}
	
	@RequestMapping(value="/score", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public String update(int wins, int losses, int ties) {
		this.wins   = wins;
		this.ties = ties;
		this.losses = losses;
		String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
		return String.format(pattern,  wins, losses, ties);	
	}
	

	@RequestMapping(value="/score/wins", method=RequestMethod.POST)
	public int increaseWins() {
		wins++;
		return wins;
	}
	@RequestMapping(value="/score/losses", method=RequestMethod.POST)
	public int increaseLosses() {
		losses++;
		return losses;
	}
	@RequestMapping(value="/score/ties", method=RequestMethod.POST)
	public int increaseTies() {
		ties++;
		return ties;
	}

	@RequestMapping(value="/score/wins", method=RequestMethod.GET)
	public int getWins() {
		return wins;
	}
	@RequestMapping(value="/score/losses", method=RequestMethod.GET)
	public int getLosses() {
		return losses;
	}
	@RequestMapping(value="/score/ties", method=RequestMethod.GET)
	public int getTies() {
		return ties;
	}

}
