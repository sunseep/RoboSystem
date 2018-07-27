package com.robo.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader implements IConfig{

	static Properties properties = new Properties();
	
	public  static void loadConfiguration() {

		InputStream input = null;

		try {

			input = new FileInputStream("C:\\Users\\sunny\\git\\RoboSystem5\\RoboSystem\\src\\com\\robo\\core\\config.properties");
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	

	@Override
	public String getProperties(String prop) {
		return properties.getProperty(prop);
	}
}