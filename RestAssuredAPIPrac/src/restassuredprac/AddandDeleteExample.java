package restassuredprac;

import static io.restassured.RestAssured.given;







import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class AddandDeleteExample {
	
	Properties p = new Properties();
	@BeforeTest
	public void getData() throws IOException{
		FileInputStream fi = new FileInputStream("F:\\New folder (3)\\RestAssuredAPIPrac\\src\\files\\rest.properties");
	p.load(fi);
	
	}
@Test
	public void addanddeleteplace() throws IOException {
	String postpayloaddata=GenerateStringFromResource("C:\\Users\\WINDOWS_10\\Desktop\\payloadexample.xml");
	
		RestAssured.baseURI=p.getProperty("host");
		Response re=given().
		queryParam("key",p.getProperty("keyvalue")).
		
		
		given().queryParam("key",p.getProperty("keyvalue")).
		body(postpayloaddata).when().
post("/maps/api/place/add/xml").
then().assertThat().statusCode(200).and().contentType(ContentType.XML).extract().response();
		String resp=re.asString();
		System.out.println(resp);
		}

public static String GenerateStringFromResource(String path)throws IOException{
	return new String(Files.readAllBytes(Paths.get(path)));
}
}
