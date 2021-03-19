package br.com.web.shift.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver = null;

	public static WebDriver getDriver() {

		String dir = System.getProperty("user.dir");
		
		if (driver == null) {
			switch (Propriedades.BROWSER) {
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", dir+"/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", dir+"/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
		}

		return driver;
	}
	
	public static void setDriver(WebDriver drive) {
		driver = drive;
	}
}
