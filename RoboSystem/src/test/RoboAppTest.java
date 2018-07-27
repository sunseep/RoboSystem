/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.robo.action.IRoboAction;
import com.robo.action.WalkAction;
import com.robo.action.WeightAction;
import com.robo.command.RoboCommandSuite;
import com.robo.core.ConfigLoader;
import com.robo.core.IConfig;
import com.robo.messagestatus.IMessageUtility;
import com.robo.messagestatus.MessageutilityImpl;
import com.robo.powermanagement.BatteryStatusUpdater;
import com.robo.powermanagement.IBatteryStatusUpdater;

/**
 * @author sunny
 *
 */
public class RoboAppTest {
	
	IMessageUtility messageUtility;
	IBatteryStatusUpdater batteryStatusUpdater;
	IConfig config;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ConfigLoader.loadConfiguration();
		batteryStatusUpdater=new BatteryStatusUpdater();
		config=new ConfigLoader();
		messageUtility=new MessageutilityImpl();
		
	}

	@Test
	public void test1() {
		IRoboAction walkAction=new WalkAction(3.5, config, batteryStatusUpdater,messageUtility);
		List<IRoboAction> actions=new ArrayList<IRoboAction>();
		actions.add(walkAction);
		RoboCommandSuite suite=new RoboCommandSuite();
		suite.executeCommand(actions);
		
	}
	
	@Test
	public void test2() {
		IRoboAction walkAction=new WalkAction(2, config, batteryStatusUpdater,messageUtility);
		IRoboAction weightAction=new WeightAction(3, config, batteryStatusUpdater,messageUtility);
		List<IRoboAction> actions=new ArrayList<IRoboAction>();
		actions.add(walkAction);
		actions.add(weightAction);
		RoboCommandSuite suite=new RoboCommandSuite();
		suite.executeCommand(actions);
	}
	
	
	@Test
	public void test3() {
		IRoboAction weightAction=new WeightAction(11, config, batteryStatusUpdater,messageUtility);
		List<IRoboAction> actions=new ArrayList<IRoboAction>();
		actions.add(weightAction);
		RoboCommandSuite suite=new RoboCommandSuite();
		suite.executeCommand(actions);
	}
	
	@Test
	public void test4() {
		IRoboAction weightAction=new WeightAction(8, config, batteryStatusUpdater,messageUtility);
		IRoboAction walkAction=new WalkAction(15, config, batteryStatusUpdater,messageUtility);
		List<IRoboAction> actions=new ArrayList<IRoboAction>();
		actions.add(weightAction);
		actions.add(walkAction);
		RoboCommandSuite suite=new RoboCommandSuite();
		suite.executeCommand(actions);
	}

}
