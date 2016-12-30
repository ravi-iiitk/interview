package com.visa.utility;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class ReadPropertyValues {
	String result = "";
	InputStream inputStream;
 
	public String getPropValues(String property) throws IOException {
		String result =null;
		try {
			Properties prop = new Properties();
			String propFileName = "resources/config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			//System.out.println(inputStream);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			// get the property value and print it out
			result = prop.getProperty(property);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}