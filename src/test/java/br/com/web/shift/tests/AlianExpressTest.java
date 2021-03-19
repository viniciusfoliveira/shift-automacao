package br.com.web.shift.tests;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.web.shift.helpers.HelperWebDriver;
import br.com.web.shift.pages.HomeAmazonPage;

public class AlianExpressTest {

	private static final String URL = "https://pt.aliexpress.com/";
	HomeAmazonPage alianPage = new HomeAmazonPage();

	@BeforeClass()
	public static void init() {	
		HelperWebDriver.init(URL);
	}
	
	@Test
	public void buscarElementos() throws IOException {
		
		alianPage.buscarProduto();
	}
	
	@AfterClass()
	public static void tearDown() {
		
		HelperWebDriver.finalizar();
	}
	
}
