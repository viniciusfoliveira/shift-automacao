package br.com.web.shift.tests;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.web.shift.helpers.HelperWebDriver;
import br.com.web.shift.pages.HomeAlieanExpressPage;

public class AlianExpressTest {

	private static final String URL = "https://pt.aliexpress.com/";
	HomeAlieanExpressPage alianPage = new HomeAlieanExpressPage();

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
