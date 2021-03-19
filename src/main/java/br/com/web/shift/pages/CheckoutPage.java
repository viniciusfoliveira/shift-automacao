package br.com.web.shift.pages;

import static br.com.web.shift.webdriver.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.web.shift.helpers.HelperScroll;
import br.com.web.shift.helpers.HelperWait;

public class CheckoutPage {

	@FindBy(how = How.XPATH, using = "//a[@title='Proceed to checkout']")
	private WebElement proceedCheckout;

	@FindBy(how = How.XPATH, using = "//button[@name='processAddress']")
	private WebElement proceedCheckoutAddress;

	@FindBy(how = How.XPATH, using = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	private WebElement proceedCheckoutSummary;

	@FindBy(how = How.XPATH, using = "//button[@name='processCarrier']")
	private WebElement proceedCheckoutCarrier;

	@FindBy(how = How.XPATH, using = "//ul[@id='order_step']/li")
	private List<WebElement> passosFormulario;

	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	@FindBy(how = How.ID, using = "SubmitLogin")
	private WebElement submitLogin;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//li[@class='address_address1 address_address2']")
	private List<WebElement> enderecos;

	@FindBy(how = How.ID, using = "cgv")
	private WebElement termosServico;

	@FindBy(how = How.CLASS_NAME, using = "bankwire")
	private WebElement pagamento;

	@FindBy(how = How.XPATH, using = "//div[@class='box cheque-box']/p")
	private List<WebElement> order;

	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clicarProceedCheckout() {
		HelperWait.waitPresenceOfElement(proceedCheckout, 60);
		proceedCheckout.click();
	}

	public void clicarProceeedCheckoutSummary() {
		proceedCheckoutSummary.click();
	}

	public void clicarProceedCheckoutAddress() {
		proceedCheckoutAddress.click();
	}

	public void clicarProceedCheckoutCarrier() {
		proceedCheckoutCarrier.click();
	}

	public WebElement getTermosServico() {
		HelperScroll.scrollParaElemento(termosServico);
		return termosServico;
	}

	public List<WebElement> getPassosFomulario() {

		for (int i = 0; i < passosFormulario.size(); i++) {
			HelperWait.waitPresenceOfElement(passosFormulario.get(i), 40);

		}
		return passosFormulario;
	}

	public String getEndereco() {

		return enderecos.get(0).getText();
	}

	public void passosOrder(String email, String senha) throws IOException {

		FileWriter arq = new FileWriter(System.getProperty("user.dir") + "/order.txt");
		BufferedWriter bw = new BufferedWriter(arq);

		for (int i = 0; i < getPassosFomulario().size(); i++) {

			if (getPassosFomulario().get(i).getText().equals("01. Summary")) {
				clicarProceeedCheckoutSummary();
			}

			if (getPassosFomulario().get(i).getText().equals("02. Sign in")) {

				this.email.sendKeys(email);
				this.password.sendKeys(senha);
				submitLogin.click();
			}

			if (getPassosFomulario().get(i).getText().equals("03. Address")) {

				assertEquals("Travessa Arlindo josé da silva", getEndereco());
				clicarProceedCheckoutAddress();
			}

			if (getPassosFomulario().get(i).getText().equals("04. Shipping")) {

				getTermosServico().click();
				clicarProceedCheckoutCarrier();
			}

			if (getPassosFomulario().get(i).getText().equals("05. Payment")) {
				pagamento.click();

				for (int j = 0; j < order.size(); j++) {

					bw.write(order.get(j).getText());
					bw.newLine();
				}
			}
		}
		bw.close();
		arq.close();
	}
}
