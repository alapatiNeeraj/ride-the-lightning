package framworkpractice;

import java.io.IOException;






import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageobject.LandingPage;
import resource.Base;


public class ValidateNavigation extends Base {
	private static Logger log=LogManager.getLogger(ValidateNavigation.class.getName());
	@BeforeTest
public void navigateUrl() throws IOException{
		drive=intDrive();
		log.info("driver intialized");
		drive.get(pr.getProperty("url"));
		log.info("navigated to the URL successfully");
		
}
@Test
	public void navigationBar() throws IOException{
		
		drive.manage().window().maximize();
		LandingPage lp = new LandingPage(drive);
		Actions act = new Actions(drive);
		WebElement b = drive.findElement(By.cssSelector("div[style*='position: absolute; top: 0px']"));
		act.click(b).build().perform();
	    
	    
	    Assert.assertTrue(lp.navigationbar().isDisplayed());
	    log.info("validation successful");
} 
@AfterTest
public void endofTest(){
	drive.close();
	
}



}
