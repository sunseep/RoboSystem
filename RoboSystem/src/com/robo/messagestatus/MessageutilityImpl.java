package com.robo.messagestatus;

import com.robo.core.RoboMessage;

public class MessageutilityImpl implements IMessageUtility {

	@Override
	public void displayLowBatteryAlert() {
		System.out.println("|||||LOW BATTERY|||||Lightened the robot head red light");
	}

	@Override
	public void showAlertMessages(String msg) {
		System.out.println("Show the message on checst LED :"+RoboMessage.valueOf(msg));
		
	}

	@Override
	public void displayBatteryStatus(int batteryBalance) {
		System.out.println("Battery :"+batteryBalance);
	}

}
