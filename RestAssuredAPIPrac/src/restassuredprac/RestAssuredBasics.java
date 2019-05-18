package restassuredprac;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredBasics {
@Test
	public void Test1() {
		// TODO Auto-generated method stub
RestAssured.baseURI="https://maps.googleapis.com";
given().
param("location","17.431178, 78.331667").
param("key", "AIzaSyBT5wYDIDnU78bg_vu3k7-rizoarOtCfzI").
param("radius", "500").
when().
get("/maps/api/place/nearbysearch/json").
then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
body("results[0].name", equalTo("Hyderabad")).and().
body("results[0].place_id",equalTo("ChIJx9Lr6tqZyzsRwvu6koO3k64")).and().
header("Server", "scaffolding on HTTPServer2");


	}

}
