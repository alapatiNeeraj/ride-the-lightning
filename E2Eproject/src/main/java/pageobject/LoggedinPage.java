package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoggedinPage {
	public WebDriver drive;
	
	
	public LoggedinPage(WebDriver drive){
		this.drive= drive;
	}




By searchquery =By.id("search-courses");






public WebElement searchQuery(){
	return drive.findElement(searchquery);
}


}
