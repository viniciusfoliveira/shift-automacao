package br.com.web.shift.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static br.com.web.shift.webdriver.DriverFactory.getDriver;

import java.util.List;

public class HomePage {

	@FindBy(how = How.ID, using = "search_query_top")
	private WebElement buscarProduto;


	@FindBy(how = How.NAME, using = "submit_search")
	private WebElement clicarBotaoBusca ;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='product-image-container']")
	private List<WebElement> produtos;

	@FindBy(how = How.XPATH, using = "//div/p/button/span[.='Add to cart']")
	private WebElement adicionarCarrinho;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void buscarProduto(String produto) {
		 buscarProduto.sendKeys(produto);
	}
	
	public void clicarBotaoBuscarProduto() {
		clicarBotaoBusca.click();
	}
	
	public void adicionarCarrinho() {		
		produtos.get(0).click();
		adicionarCarrinho.click();
	}
	
}
