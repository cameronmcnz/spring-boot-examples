package com.mcnz.spring.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mcnz.jee.soap.GetScoreRequest;
import com.mcnz.jee.soap.GetScoreResponse;
import com.mcnz.jee.soap.Score;

@Endpoint
public class ScoreEndpoint {

	@PayloadRoot(namespace = "http://soap.jee.mcnz.com/", localPart = "getScoreRequest")
	@ResponsePayload
	public GetScoreResponse getScore(@RequestPayload GetScoreRequest request) {
		Score score = new Score();
		if (request.getUser().equalsIgnoreCase("Scrumtuous")) {
			score.setWins(100);
		} else {
			score.setWins(99);
			score.setLosses(66);
			score.setTies(7);
		}
		GetScoreResponse response = new GetScoreResponse();
		response.setScore(score);
		return response;
	}

}






