package com.robo.powermanagement;

import com.robo.messagestatus.IMessageUtility;

public interface IBatteryStatusUpdater {
	
	public void updateBatteryStatus(int batteryPercentage, IMessageUtility messageUtility);
	
	public void showBatteryStatus(IMessageUtility messageUtility);

}
