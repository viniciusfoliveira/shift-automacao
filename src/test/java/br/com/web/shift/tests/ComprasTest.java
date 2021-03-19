package br.com.web.shift.tests;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.web.shift.helpers.HelperWebDriver;
import br.com.web.shift.pages.CheckoutPage;
import br.com.web.shift.pages.HomePage;


public class ComprasTest {

	private static final String URL = "http://automationpractice.com/index.php";
	
	HomePage homePage = new HomePage();
	CheckoutPage checkoutPage = new CheckoutPage();
	
	@BeforeClass()
	public static void init() {	
		HelperWebDriver.init(URL);
	}
	
	@Test
	public void efetuarCompra() throws IOException {
		
		homePage.buscarProduto("Blouse");
		homePage.clicarBotaoBuscarProduto();
		homePage.adicionarCarrinho();
		checkoutPage.clicarProceedCheckout();
		checkoutPage.passosOrder("viniciusferreira482@gmail.com", "123456vnk");
		
	}
	
	@AfterClass()
	public static void tearDown() {
		HelperWebDriver.finalizar();
	}
}
