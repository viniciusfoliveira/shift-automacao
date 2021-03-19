package br.com.web.shift.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.com.web.shift.webdriver.DriverFactory.getDriver;


public class HelperWait {

	public  static WebElement waitPresenceOfElement(WebElement locator, int timeout){
		 return new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOf(locator));
	}
}
