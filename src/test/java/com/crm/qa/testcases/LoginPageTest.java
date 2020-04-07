package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Validate the Tittle on Login page")
	public void validateTheTittleTest() {
		String tittle =  loginPage.validateTheTittle();
		Assert.assertEquals(tittle, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Validate the URL of Login page")
	public void validateTheURLTest() {
		String url = loginPage.validateTheURL();
		Assert.assertEquals(url, "https://ui.freecrm.com/");
	}
	
	@Test(priority = 3)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Validate the Login functionality")
	public void loginTest() throws IOException, InterruptedException {
		homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
