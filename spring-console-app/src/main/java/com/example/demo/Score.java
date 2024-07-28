package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Score {
	

	@Id
	Long id;
	int wins, losses, ties;
	
	public Score() {
		super();
	}

	public Score(int wins, int losses, int ties) {
		super();
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", wins=" + wins + ", losses=" + losses + ", ties=" + ties + "]";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}
	

}
