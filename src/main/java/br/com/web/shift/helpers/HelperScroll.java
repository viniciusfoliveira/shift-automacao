package br.com.web.shift.helpers;

import org.openqa.selenium.WebElement;
import static br.com.web.shift.webdriver.DriverFactory.getDriver;
import org.openqa.selenium.JavascriptExecutor;

public class HelperScroll {

	
	public static  void scrollParaElemento(WebElement elemento) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", elemento);
	}
}
