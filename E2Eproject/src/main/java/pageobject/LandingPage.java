package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
	public WebDriver drive;
	
	
	public LandingPage(WebDriver drive){
		this.drive= drive;
	}




By login =By.cssSelector("a[href*='qaclickacademy.usefedora.com/sign_in']");
By title= By.cssSelector("div.text-center");
By navigatebar= By.cssSelector("ul.nav.navbar-nav.navbar-right");
By popup= By.xpath("//button[text()='NO THANKS']");




public WebElement loginselect(){
	return drive.findElement(login);
}

public WebElement Title() {
	return drive.findElement(title);
}
public WebElement navigationbar(){
	return drive.findElement(navigatebar);
}
public WebElement popuphandle(){
	return drive.findElement(popup);
	
}

public List<WebElement> popupdisplayed(){
	return drive.findElements(popup);
	
}
}
