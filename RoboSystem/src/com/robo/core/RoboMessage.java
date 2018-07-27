package com.robo.core;

public enum RoboMessage {
	
	Overweight("Overweight"),SCANFAILURE("Scan Failure"),NotEnoughBattery("Not enough battery for this action");
	String value;
	private RoboMessage(String value) {
		this.value=value;
	}
	
}
