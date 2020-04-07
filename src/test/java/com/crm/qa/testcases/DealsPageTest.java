package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DealsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	
	public DealsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initalization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate the Deals page tittle")
	public void verifyDealsPageLabelTest() throws IOException {
		String dealsPageLabel = dealsPage.verfiyDealsLabel();
		Assert.assertEquals(dealsPageLabel, "Deals");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
