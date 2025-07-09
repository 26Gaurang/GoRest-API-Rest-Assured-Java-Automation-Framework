package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

	
	public static Properties Globalprop() throws IOException{
		
		Properties p = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\customer\\eclipse-workspace\\Ecommerce_Rest_Assured_API\\src\\test\\resources\\config.properties");
		
		p.load(fis);
		
		p.getProperty("url");
	
		p.getProperty("token");
		
		return p;
		
	}
	
	
}
