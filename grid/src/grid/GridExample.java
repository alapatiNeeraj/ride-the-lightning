package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
DesiredCapabilities d = new DesiredCapabilities();
d.setBrowserName("chrome");
d.setPlatform(Platform.WINDOWS);
WebDriver drive = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), d);
drive.get("https://www.google.com");
drive.getTitle();

	}

}
