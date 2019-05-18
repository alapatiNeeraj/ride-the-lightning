package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
public WebDriver drive;
public Properties pr;
	public WebDriver intDrive() throws IOException {
		// TODO Auto-generated method stub
 pr = new Properties();
FileInputStream fi = new FileInputStream("C:\\Users\\WINDOWS_10\\E2Eproject\\src\\main\\java\\resource\\Data.properties");
pr.load(fi);
if(pr.getProperty("browser").equals("chrome")){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\WINDOWS_10\\Desktop\\Selenium\\drivers\\chromedriver.exe");
	drive = new ChromeDriver();
	
}
else if (pr.getProperty("browser").equals("firefox")) {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\WINDOWS_10\\Desktop\\Selenium\\drivers\\geckodriver.exe");
	drive = new FirefoxDriver();	
	
}
else if (pr.getProperty("browser").equals("ie")) {
	System.setProperty("webdriver.ie.driver","C:\\Users\\WINDOWS_10\\Desktop\\Selenium\\drivers\\MicrosoftWebDriver.exe");
	 drive = new InternetExplorerDriver();
}
drive.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
return drive;

	}

	public void getScreenshot(String results) throws IOException{
		File s = ((TakesScreenshot)drive).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File("C:\\Users\\Public\\Downloads\\"+results+"screenshotE2Efailures.png"));
	}
}
