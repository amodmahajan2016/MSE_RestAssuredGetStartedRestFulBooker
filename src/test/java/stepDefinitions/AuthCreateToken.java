package stepDefinitions;

import org.hamcrest.Matchers;

import Models.Auth;
import Models.Token;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AuthCreateToken {
	
	Auth authPayload;
	Token authResponse;
	@Given("Auth - CreateToken end point is setup")
	public void auth_create_token_end_point_is_setup() {
		// Setting up Base URI and Base Path
				RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
				RestAssured.basePath ="auth";
	}

	@When("Auth - CreateToken payload is created")
	public void auth_create_token_payload_is_created() {
		// Creating payload for auth api
		authPayload = new Auth();
		authPayload.setUsername("admin");
		authPayload.setPassword("password123");
	}
	
	@Given("Auth - CreateToken end point is hit")
	public void auth_create_token_end_point_is_hit() {
		
				
				authResponse = 
				RestAssured
				   .given()
				   	  .log()
				   	  .all()
					  .body(authPayload)
					  .contentType(ContentType.JSON)
				   .when()
				   	  .post()
				   .then()
				   	  .log()
				   	  .all()
				   	  .assertThat()
				   	  .statusCode(200)
				   	   // Asserting token is generated and not null
				   	  .body("token", Matchers.notNullValue())
				   	  .extract()
				   	  .as(Token.class);
				
				System.out.println("Generated token : "+ authResponse.getToken());
	}

	@Then("a valid token should be generated")
	public void a_valid_token_should_be_generated() {
		System.out.println("Generated token : "+ authResponse.getToken());
	}
}
