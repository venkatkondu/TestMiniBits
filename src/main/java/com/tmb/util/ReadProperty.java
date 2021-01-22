package com.tmb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperty {
	// I don't want to extended this class to the another classes for that I make it as final access modifier to the class level 
	private ReadProperty()
	{
	// I don't want to allow to create Object of this class explicitly  for that I make it as private  access modifier to this constructor	
		
	}
	public static String getKeyValue(String key)
	{
		String val="";
		Properties property=new Properties();
		
		FileInputStream fis;
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
			System.out.println("FileInputStram  is loaded Property file path - for get the key - value ");
			try {
				property.load(fis);System.out.println("Property file is loaded for the get the value from the property file ");
			} catch (IOException e) {
					System.out.println("Property file is not loaded for the key and value from the proprty file ");		
					e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Property file is not loaded please check the file path ::   ./src/main/resources/config/config.properties");	
			e.printStackTrace();
		}
		val=property.getProperty(key);
		System.out.println("get the value from the Property this key = "+val); //later On I will mute it 
		
		return val;
	}
}
