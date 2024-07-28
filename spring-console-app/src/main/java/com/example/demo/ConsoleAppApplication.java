package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleAppApplication implements CommandLineRunner {
	
	//@Autowired
	//Score score;
	
	@Autowired
	ScoreRepository scoreRepo;

	public static void main(String[] args) {
		SpringApplication.run(ConsoleAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		Score score = scoreRepo.findById(Long.valueOf(1)).get();
		String result = "";
		String gesture = "";
		do {
			gesture = scanner.next();
			if (gesture.equalsIgnoreCase("rock")) {
				score.wins++;
				result = "tie";
			}
			if (gesture.equalsIgnoreCase("paper")) {
				score.ties++;
				result = "win";
			}
			if (gesture.equalsIgnoreCase("scissors")) {
				score.losses++;
				result = "loss";
			}
			System.out.println("You chose rock. The result is a: " + result);
			System.out.println("The score is: " + score);
		} while (!gesture.equalsIgnoreCase("q"));
		scanner.close();
		
		
	}

}
