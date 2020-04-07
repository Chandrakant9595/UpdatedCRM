package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initalization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Validate the Tittle on Home page")
	public void verifyHomePgeTittleTest() {
		String homePageTittle =  homePage.verifyTheTittle();
		Assert.assertEquals(homePageTittle, "Cogmento CRM", "Home page title not correct");
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Validate the User name on Home page")
	public void verifyUserNameTest() {
		String userName =  homePage.verifyUserName();
		Assert.assertEquals(userName, "Chandrakant Shinde");
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Validate the Click functionality on Contact link on Home page")
	public void verifyContactLinkTest() throws IOException {
		contactsPage = homePage.clickOnContactLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
