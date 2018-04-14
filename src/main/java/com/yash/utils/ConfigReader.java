package com.yash.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public String TestProperties(String SKey) throws IOException
	{
		
		FileInputStream fis= new FileInputStream("./src/test/resources/Properties/TestProperties.properties");
		Properties prop= new Properties();
		
		prop.load(fis);
		
		return prop.getProperty(SKey);
		
		
		
	}

}
