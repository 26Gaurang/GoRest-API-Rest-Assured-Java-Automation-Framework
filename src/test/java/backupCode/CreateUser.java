package backupCode;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utils.CreateUserPayload;
import utils.SpecBuilder;

import static io.restassured.RestAssured.*;


public class CreateUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		
		// POST	REQUEST		
				String CreateUser = RestAssured
						.given().spec(SpecBuilder.SetRequest())
						.body(CreateUserPayload.Postpayload("Tyrion Lannister ","Dwarf97@gameOfThrones.com","Male", "active"))
						.when().post()
						.then().spec(SpecBuilder.GetResponse())
						.assertThat().statusCode(201)
						.extract().response().asString();
				
				
				JsonPath js = new JsonPath(CreateUser);
				
				int UserId = js.getInt("id");
				System.out.println(UserId);	
		
		
				// GET REQUEST
				
				String FetchUser = RestAssured
						.given().spec(SpecBuilder.SetRequest()).pathParam("id", UserId)
						.when().get("/{id}")
						.then().spec(SpecBuilder.GetResponse())
						.assertThat().statusCode(200)
						.extract().response().asString();
				
				JsonPath js1 = new JsonPath(FetchUser);
				String username = js1.getString("name");
				System.out.println(username);

				// PUT REQUEST
				
				String UpdateUser = RestAssured
						.given().spec(SpecBuilder.SetRequest()).pathParam("id", UserId)
						.body(CreateUserPayload.Putpayload("name","Jamie Lannister 497"))
						.when().patch("/{id}")
						.then().spec(SpecBuilder.GetResponse())
						.assertThat().statusCode(200)
						.extract().response().asString();
				
				JsonPath js2 = new JsonPath(UpdateUser);
				String newUserName = js2.getString("name");
				System.out.println(newUserName);

				// DELETE REQUEST	
				
				String DeleteUser = RestAssured
						.given().spec(SpecBuilder.SetRequest()).pathParam("id", UserId)
						.when().delete("/{id}")
						.then()
						.assertThat().statusCode(204)
						.extract().response().asString();
			
	

		
	}
	

}
