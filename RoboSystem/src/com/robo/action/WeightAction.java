package com.robo.action;

import com.robo.core.IConfig;
import com.robo.messagestatus.IMessageUtility;
import com.robo.powermanagement.BatteryStatusUpdater;
import com.robo.powermanagement.IBatteryStatusUpdater;

public class WeightAction implements IRoboAction{
	
	private double weight;
	private IConfig config;
	private IBatteryStatusUpdater batteryStatusUpdater;
	private IMessageUtility messageUtility;
	
	public WeightAction(double weight, IConfig config, IBatteryStatusUpdater batteryStatusUpdater,IMessageUtility messageUtility)
	{
		this.weight=weight;
		this.config=config;
		this.batteryStatusUpdater=batteryStatusUpdater;
		this.messageUtility=messageUtility;
	}
	
	private int getBatteryConsumption()
	{
		String batteryConsumptionPerUnit=config.getProperties("robo.weight.battery.consumption");
		return new Integer(batteryConsumptionPerUnit).intValue();
	}
	
	@Override
	public void doAction() {
		if(this.weight > 10)
		{
			messageUtility.showAlertMessages("Overweight");
		}
		
		else if(BatteryStatusUpdater.getBalanceBattery() > 15)
		{
			System.out.println("hanging the weight :"+this.weight);
			int batteryConsumption=(int)Math.round(getBatteryConsumption()*this.weight);
			batteryStatusUpdater.updateBatteryStatus(batteryConsumption,messageUtility);
			batteryStatusUpdater.showBatteryStatus(messageUtility);
		}
		else
		{
			messageUtility.displayLowBatteryAlert();
		}
		
	}
}
