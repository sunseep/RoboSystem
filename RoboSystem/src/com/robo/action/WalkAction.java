package com.robo.action;

import com.robo.core.IConfig;
import com.robo.messagestatus.IMessageUtility;
import com.robo.powermanagement.BatteryStatusUpdater;
import com.robo.powermanagement.IBatteryStatusUpdater;

public class WalkAction implements IRoboAction{

	private double distance;
	private IConfig config;
	private IBatteryStatusUpdater batteryStatusUpdater;
	private IMessageUtility messageUtility;
	
	public WalkAction(double distance, IConfig config, IBatteryStatusUpdater batteryStatusUpdater, IMessageUtility messageUtility)
	{
		this.distance=distance;
		this.config=config;
		this.batteryStatusUpdater=batteryStatusUpdater;
		this.messageUtility=messageUtility;
	}
	
	private int getBatteryConsumption()
	{
		String batteryConsumptionPerUnit=config.getProperties("robo.walk.battery.consumption");
		
		return new Integer(batteryConsumptionPerUnit).intValue();
		
	}
	
	@Override
	public void doAction() {
		if(BatteryStatusUpdater.getBalanceBattery() < 15)
		{
			messageUtility.displayLowBatteryAlert();
		}
		else if(BatteryStatusUpdater.getBalanceBattery() > (getBatteryConsumption()*this.distance))
		{
			System.out.println("Walk Action Executed");
			int bateryConsumedInAction=(int)Math.round((getBatteryConsumption()*this.distance));
			batteryStatusUpdater.updateBatteryStatus(bateryConsumedInAction,messageUtility);
			batteryStatusUpdater.showBatteryStatus(messageUtility);
		}
		
		else
		{
			messageUtility.showAlertMessages("NotEnoughBattery");
		}
	}
}
