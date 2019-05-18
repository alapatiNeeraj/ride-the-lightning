package pageobject;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	public WebDriver drive;
	
	
	public LoginPage(WebDriver drive){
		this.drive= drive;
	}

By email = By.id("user_email");
By password = By.id("user_password");
By loginbutton = By.name("commit");


public WebElement emailAdd(){
	return drive.findElement(email);
}
public WebElement pass(){
	return drive.findElement(password);
}

public WebElement lb(){
	return drive.findElement(loginbutton);
}





}
