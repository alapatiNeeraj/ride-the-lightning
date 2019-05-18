package restassuredprac;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import files.Payload;
import files.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//this is json validation , the class name has been given wrong
public class AddandDeleteExampleWithXml {
	Properties p = new Properties();
	@BeforeTest
	public void getData() throws IOException{
		FileInputStream fi = new FileInputStream("F:\\New folder (3)\\RestAssuredAPIPrac\\src\\files\\rest.properties");
	p.load(fi);
	
	}
@Test
	public void addanddeleteplace() {
		
		//grabbing the response
		RestAssured.baseURI=p.getProperty("host");
		Response r=given().
		queryParam("key",p.getProperty("keyvalue")).
		body(Payload.bodyaddanddeletexample()).
		when().
		post(Resources.postvalueforaddanddeletexample()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK") ).extract().response();
		//task2 - grabbing the placeid from response
	String responsestring = r.asString(); // converts the response into string
		System.out.println(responsestring);
		JsonPath jp = new JsonPath(responsestring); // converts the string response into JSON
		String pid=jp.get("place_id");
		System.out.println(pid);
		//task3 - place this place id in the delete request
		given().queryParam("key","qaclick123").
		body("{"+
    "\"place_id\":\""+pid+"\""+           
"}").when().
post("/maps/api/place/delete/json").
then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
body("status",equalTo("OK"));
		
		}
}
