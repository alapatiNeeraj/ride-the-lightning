package dbt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DbtPrac {

	public static void main(String[] args) throws SQLException {
		String host="localhost";
		String port="3306";
		//System.out.println("hi");
		
		// TODO Auto-generated method stub
Connection co=DriverManager.getConnection("jdbc:mysql://" + host + ":"+ port +"/sdbt","root","speedforce1234");
Statement s= co.createStatement();
ResultSet re =s.executeQuery("select * from prac");
while(re.next()){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\WINDOWS_10\\Desktop\\Selenium\\drivers\\chromedriver.exe");
	WebDriver drive = new ChromeDriver();
	drive.get("https://login.salesforce.com/?locale=in");
	drive.manage().window().maximize();
	drive.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	drive.findElement(By.id("username")).sendKeys(re.getString("username"));
	drive.findElement(By.id("password")).sendKeys(re.getString("password"));

}
	}

}
