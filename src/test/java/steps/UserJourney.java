package steps;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import utils.CreateUserPayload;
import utils.SpecBuilder;

public class UserJourney {

	int UserId;
	
	
	@Given("I create a user using POST Request with {string}, {string}, {string}, {string}")
	public void CreateUser(String name, String email, String gender, String status) {
		// POST	REQUEST		
		String CreateUser = RestAssured
				.given().spec(SpecBuilder.SetRequest())
				.body(CreateUserPayload.Postpayload(name,email,gender,status))
				.when().post()
				.then().spec(SpecBuilder.GetResponse())
				.assertThat().statusCode(201)
				.extract().response().asString();
		
		
		JsonPath js = new JsonPath(CreateUser);
		
		UserId = js.getInt("id");
		System.out.println("User id generated is "+UserId);	
		
	}
	
	@When("I retrieve user details using GET Request")
	public void GetUser() {
		
		// GET REQUEST
		
				String FetchUser = RestAssured
						.given().spec(SpecBuilder.SetRequest()).pathParam("id", UserId)
						.when().get("/{id}")
						.then().spec(SpecBuilder.GetResponse())
						.assertThat().statusCode(200)
						.extract().response().asString();
				
				JsonPath js1 = new JsonPath(FetchUser);
				int id = js1.getInt("id");
				String username = js1.getString("name");
				String emailId = js1.getString("email");
				String gender = js1.getString("gender");
				String status = js1.getString("status");
				System.out.println(id+" , "+username+" , "+emailId+" , "+gender+" , "+status);
		
	}
	
	@And("I modify user using PATCH Request with {string} field and {string} value")
	public void UpdateUser(String PatchField, String PatchValue) {
		
		// PUT REQUEST
		
				String UpdateUser = RestAssured
						.given().spec(SpecBuilder.SetRequest()).pathParam("id", UserId)
						.body(CreateUserPayload.Putpayload(PatchField, PatchValue))
						.when().patch("/{id}")
						.then().spec(SpecBuilder.GetResponse())
						.assertThat().statusCode(200)
						.extract().response().asString();
				
				JsonPath js2 = new JsonPath(UpdateUser);
				String updatedValue = js2.getString(PatchField);
				System.out.println(updatedValue);
	}
	
	@And("I remove the user using DELETE Request")
	public void DeleteUser() {
		
		// DELETE REQUEST	
		
				String DeleteUser = RestAssured
						.given().spec(SpecBuilder.SetRequest()).pathParam("id", UserId)
						.when().delete("/{id}")
						.then()
						.assertThat().statusCode(204)
						.extract().response().asString();
			
	}
	
	
	@Then("I try to retrieve user details using GET Request")
	public void GetUserNegative() {
		
		// GET REQUEST
		
		String FetchUser = RestAssured
				.given().spec(SpecBuilder.SetRequest()).pathParam("id", UserId)
				.when().get("/{id}")
				.then().spec(SpecBuilder.GetResponse())
				.assertThat().statusCode(404)
				.extract().response().asString();
		
		JsonPath js1 = new JsonPath(FetchUser);
		String validatemsg = js1.getString("message");
		System.out.println(validatemsg);
		
		// Assert expected msg - Resource not found
		
	}
	
	
	
	
	
}
