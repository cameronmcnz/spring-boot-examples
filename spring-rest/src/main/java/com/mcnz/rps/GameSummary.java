package com.mcnz.rps;

import java.time.LocalTime;

public class GameSummary {

	Long id;

	String clientGesture;
	String serverGesture;
	String result;
	LocalTime timestamp = LocalTime.now();
	
	public GameSummary(String clientGesture, String serverGesture, String result) {
		super();
		this.clientGesture = clientGesture;
		this.serverGesture = serverGesture;
		this.result = result;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientGesture() {
		return clientGesture;
	}

	public void setClientGesture(String clientGesture) {
		this.clientGesture = clientGesture;
	}

	public String getServerGesture() {
		return serverGesture;
	}

	public void setServerGesture(String serverGesture) {
		this.serverGesture = serverGesture;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
