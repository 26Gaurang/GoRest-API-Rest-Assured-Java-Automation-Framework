package utils;

import java.io.IOException;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	
	
	public static RequestSpecification SetRequest() {
	
			Properties prop = null;
			try {
				prop = ConfigManager.Globalprop();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new RequestSpecBuilder()
					.setBaseUri(prop.getProperty("url"))
					.setContentType(ContentType.JSON)
					.addHeader("Authorization", "Bearer "+prop.getProperty("token"))
					.build();	
		
	}
	
	public static ResponseSpecification GetResponse() {
		
		return new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
		
	}
	
}
