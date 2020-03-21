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
	public void verifyHomePgeTittleTest() {
		String homePageTittle =  homePage.verifyTheTittle();
		Assert.assertEquals(homePageTittle, "Cogmento CRM", "Home page title not correct");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		String userName =  homePage.verifyUserName();
		Assert.assertEquals(userName, "Chandrakant Shinde");
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest() throws IOException {
		contactsPage = homePage.clickOnContactLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
