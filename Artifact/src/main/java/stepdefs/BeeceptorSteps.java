package stepdefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.collection.HasItemInArray;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BeeceptorSteps {
	Response response2;

	@Given("Get the end point url {string}")
	public void get_the_end_point_url(String uri) {
	    RestAssured.baseURI = uri;
	}

	@Then("Validate Success response")
	public void validate_success_response() {
	    Response response = RestAssured.get();
	    response.prettyPrint();
	    response.then().assertThat().statusCode(200);
	}

	@Then("Validate the path as {string}")
	public void validate_the_path_as(String pathValue) {
	    Response response = RestAssured.get();
	    JsonPath jsonpath = response.jsonPath();
	    assertEquals(jsonpath.get("path"), pathValue);
	}
	
	@Then("Validate the ip as {string}")
	public void validate_the_ip_as(String ip) {
	    Response response = RestAssured.get();
	    JsonPath jsonpath = response.jsonPath();
	    assertTrue(jsonpath.get("ip").toString().contains(ip));
	}
	
	@Given("Post the end point url {string}")
	public void post_the_end_point_url(String uri) {
		File jsonInputFile = new File("./src/main/resources/RequestBody.json");
		RestAssured.baseURI = uri;
		RequestSpecification inputRequest = RestAssured.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON);
		response2 = inputRequest.body(jsonInputFile)
			.when()
			.post();
		response2.prettyPrint();
		response2.then().assertThat().statusCode(200);
	}
	
	@Then("Validate the customer name as {string}")
	public void validate_the_customer_name_as(String cNameExpected) {
		String cNameActual = response2.then().extract().path("parsedBody.customer.name");
		assertEquals(cNameActual, cNameExpected);
	}
	
	@Then("Validate the customer email as {string}")
	public void validate_the_customer_email_as(String emailExpected) {
		String emailActual = response2.then().extract().path("parsedBody.customer.email");
		assertEquals(emailActual, emailExpected);
	}
	
	@Then("Validate the payment amount as {string}")
	public void validate_the_payment_amount_as(String amountExpected) {
		Float amountActual = response2.then().extract().path("parsedBody.items[0].price");
		System.out.println(amountActual);
		assertEquals(amountActual.toString(), amountExpected);
	}
}
