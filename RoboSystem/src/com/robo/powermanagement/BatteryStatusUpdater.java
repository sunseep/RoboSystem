package com.robo.powermanagement;

import com.robo.messagestatus.IMessageUtility;

public class BatteryStatusUpdater implements IBatteryStatusUpdater{
	static int  balanceBattery=100;
	
	public static int getBalanceBattery() {
		return balanceBattery;
	}

	
	@Override
	public void updateBatteryStatus(int batteryPercentage, IMessageUtility messageUtility) {
		balanceBattery = balanceBattery-batteryPercentage;
		if(balanceBattery <=15)
		{
			messageUtility.displayLowBatteryAlert();
		}
	}

	@Override
	public void showBatteryStatus(IMessageUtility messageUtility) {
		messageUtility.displayBatteryStatus(balanceBattery);
	}
	
	
	
	

	

}
