package com.robo.command;

import java.util.List;

import com.robo.action.IRoboAction;

public class RoboCommandSuite {
	
	
	
	public void executeCommand(List<IRoboAction> listAction)
	{
		for(IRoboAction action:listAction)
		{
			action.doAction();
		}
	}
	
	

}
