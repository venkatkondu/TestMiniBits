package com.tmb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadProperty2 {
	
	private ReadProperty2()
	{
		
	}
	
	// for eager initializations  
	
	private static Properties property=new Properties();// this is required 
	private static final Map<String,String> mapKV=new HashMap<String,String>();// I don't want to allow // why it is final I will check later 
	private static File file=new File(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");// pass the property file name 
	private static FileInputStream fInStream;
	// I Need property file location 
	// I need Eager Initializations 
	static {
		try {
			fInStream=new FileInputStream(file);System.out.println("property file load from the specified path");
			try {
				property.load(fInStream);System.out.println("Propeties file is loaded from the FileInputStream");
			} catch (IOException e) {
				System.out.println("Properties file is not loaded from the FileInputStream check the code");
				e.printStackTrace();
			}// for load the InputStream to the Properties 
			
			// After Loading all the FileInputStream and Properties file I wan to get all the key add it's values into the Map<> 
			// below for loop execute how many key are there inside the Property file 
		/*
			for(Object key: property.keySet())// get all the key inside the properties file and stored into a map
			{
				// I have to store these key and it's values 
				mapKV.put((String) key, (String) property.get(key)); // check this will work or not
			}
		*/	
			for(Map.Entry<Object, Object> entry:property.entrySet()) // this is another way of inserting the key and it's values into the Map reference
			{
				mapKV.put((String)entry.getKey(),(String)entry.getValue());
			}
			
			// Another way  I am using the LamdaExpression consumer problem
		//	property.entrySet().forEach(entry -> mapKV.put((String)entry.getKey(),(String)entry.getValue()));
		
		} catch (FileNotFoundException e) {
			System.out.println("Property file is not loaded from the specified path please check the path ::"+file.getPath());
			e.printStackTrace();
		}// for get the file from the specified path
		
		
	}
	
	public static String getKeyVal(String key) throws Exception // this method is for get the property values from the directly 
	{
		String keyVal=property.getProperty(key);
		
		if(Objects.isNull(keyVal)||Objects.isNull(key))
		{
			System.out.println("Property Name :: "+key+"  :: Is Not found in the Property file ");
			throw new Exception("Property Name :: "+key+"  :: Is Not found in the Property file ");
		}
		
		
		return keyVal;
	}
	
	// Below method get the value from the Map reference variable 
	public static String getKVMap(String key) throws Exception
	{
		String keyVal=mapKV.get(key); // how to get this value from the map reference variable 
		// I have to validate is there any miss functions is available or not 
		 if(Objects.isNull(keyVal)|Objects.isNull(key))// if the key and it's value is null then get the 
		 {
			System.out.println("Property Name :: "+key+"  :: Is Not found in the Property file ");
			throw new Exception("Property Name :: "+key+"  :: Is Not found in the Property file ");
			
		 }
		
		return keyVal;
		
	}

}
