package com.knacksystems.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil 
{
	public static String getValueForKey(String key) throws Throwable
	{
		Properties configProp=new Properties();
		configProp.load(new FileInputStream(new File("./ConfigFile/Environment.properties")));
		return configProp.getProperty(key);
	}
}
