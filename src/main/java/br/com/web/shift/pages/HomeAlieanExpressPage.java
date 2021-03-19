package br.com.web.shift.pages;

import static br.com.web.shift.webdriver.DriverFactory.getDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.web.shift.helpers.HelperWait;

public class HomeAlieanExpressPage {

	@FindBy(how = How.ID, using = "search-key")
	private WebElement inserirTexto;

	@FindBy(how = How.CLASS_NAME, using = "search-button")
	private WebElement buscarProduto;

	@FindBy(how = How.XPATH, using = "//span[@class='price-current']")
	private List<WebElement> valores;

	private List<String> telefones;

	public HomeAlieanExpressPage() {
		PageFactory.initElements(getDriver(), this);

	}

	public void inserirTextoNaBusca(String smartphone) {
		inserirTexto.sendKeys(smartphone);
	}

	public void clicarBuscaSmartphone() {
		buscarProduto.click();
	}

	public List<WebElement> getValores() {

		for (int i = 0; i < valores.size(); i++) {
			HelperWait.waitPresenceOfElement(valores.get(i), 120);

		}
		return valores;
	}

	public void limparTextoNaBusca() {
		inserirTexto.clear();
	}

	public void buscarProduto() throws IOException {

		File file = new File(System.getProperty("user.dir") + "/produto.xlsx");
		// ler um arquivo

		FileInputStream fos = new FileInputStream(file);

		// pega todas as planilhas
		XSSFWorkbook workbook = new XSSFWorkbook(fos);

		// pega uma em especifico
		XSSFSheet sheetMoedas = workbook.getSheetAt(0);

		buscarProduto(sheetMoedas);

		// escreve no arquivo
		FileOutputStream os = new FileOutputStream(file);
		workbook.write(os);
	}

	private void buscarProduto(XSSFSheet sheetMoedas) {
		telefones = new ArrayList<String>();
		telefones.add("Samsung Galaxy S10+");
		telefones.add("Xiaomi Redmi Note 9 Pro");
		telefones.add("IPhone 11");

		int row = 1;

		for (int i = 0; i < telefones.size(); i++) {

			String[] rows = new String[2];

			inserirTextoNaBusca(telefones.get(i));
			clicarBuscaSmartphone();

			rows[0] = telefones.get(i);
			rows[1] = valores.get(1).getText();

			Row r = sheetMoedas.createRow(row);

			for (int k = 0; k < rows.length; k++) {

				org.apache.poi.ss.usermodel.Cell c = r.createCell(k);
				c.setCellValue(rows[k]);

			}
			row++;
			limparTextoNaBusca();
		}

	}
}
