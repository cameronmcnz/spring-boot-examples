package com.mcnz.ioc.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameService {
	
	//Score score = new Score();
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring-context.xml");
	Score score = context.getBean("thescore", Score.class);
	
	
	public void playTheGame(String clientGesture) {
		if (clientGesture.equalsIgnoreCase("scissors")) { score.losses++;}
		if (clientGesture.equalsIgnoreCase("paper")) { score.wins++;}
		if (clientGesture.equalsIgnoreCase("rock")) { score.ties++;}
	}
	
	
	public static void main (String args[]) {
		GameService gs = new GameService();
		gs.playTheGame("scissors");
		gs.playTheGame("paper");
		gs.playTheGame("scissors");
		gs.playTheGame("paper");

		System.out.print("Wins: " + gs.score.wins);
		System.out.print("..Losses: " + gs.score.losses);
		System.out.print("..Ties: " + gs.score.ties);


		
	}
	

}
