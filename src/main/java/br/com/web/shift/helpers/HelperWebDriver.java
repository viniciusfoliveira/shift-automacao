package br.com.web.shift.helpers;

import static br.com.web.shift.webdriver.DriverFactory.getDriver;
import static br.com.web.shift.webdriver.DriverFactory.setDriver;

public class HelperWebDriver {

	public static void init(String url) {

		getDriver().get(url);
		getDriver().manage().window().maximize();
	}

	public static void finalizar() {

		if (getDriver() != null) {
			getDriver().quit();
			setDriver(null);
		}
	}
}
