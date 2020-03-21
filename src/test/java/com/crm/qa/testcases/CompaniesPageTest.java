package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddNewCompanyPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CompaniesPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CompaniesPage comaniesPage;
	AddNewCompanyPage addNewCompanyPage;
	
	String sheetName = "Company";
	
	public CompaniesPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initalization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		comaniesPage = homePage.clickOnCompaniesLink();
	}
	
	@Test(priority=1)
	public void verifyContactPageLabelTest() throws IOException {
		String companiesPageLabel = comaniesPage.verfiyCompaniesLabel();
		Assert.assertEquals(companiesPageLabel, "Companies");
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getDataFromExcel")
	public void addNewCompanyTest(String coName) throws InterruptedException, IOException {
		addNewCompanyPage = comaniesPage.clickOnNewCompanyButton();
		addNewCompanyPage.addNewCompany(coName);
		Thread.sleep(5000);
		homePage.clickOnCompaniesLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
