package framworkpractice;

import java.io.IOException;






import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



import org.testng.annotations.AfterSuite;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.LoginPage;
import resource.Base;

public class HomePage extends Base {
	private static Logger log=LogManager.getLogger(HomePage.class.getName());

@Test(dataProvider="getData")
	public void navigate(String username,String password,String text) throws IOException{
	
	drive=intDrive();
	log.info("driver intialized");
	drive.get(pr.getProperty("url"));
	log.info("navigated to the URL successfully");
		drive.manage().window().maximize();
		LandingPage lp = new LandingPage(drive);
		Actions act = new Actions(drive);
		WebElement b = drive.findElement(By.cssSelector("div[style*='position: absolute; top: 0px']"));
		act.click(b).build().perform();
	    lp.loginselect().click();
	    LoginPage lo = new LoginPage(drive);
	    lo.emailAdd().sendKeys(username);
	    lo.pass().sendKeys(password);
	    lo.lb().click();
	    log.info(text);
	   drive.close();
	   
}
@AfterSuite
public void endofTest(){
	drive.quit();
	
}

@DataProvider
public Object[][] getData(){
	//row stands for how many different types of data types test should run.
	//column stands for how many values should be passed for test.
	Object[][] data = new Object[2][3];
	//1st row
	data[0][0]="test@gmail.com";
	data[0][1]="23467712";
	data[0][2]="forca";
	
	//2nd row
	data[1][0]="test1@gmail.com";
	data[1][1]="234456712";
	data[1][2]="audible";
	return data;
}
}
