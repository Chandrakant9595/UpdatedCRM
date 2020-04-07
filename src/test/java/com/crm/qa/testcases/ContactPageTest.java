package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddNewContactPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	AddNewContactPage addNewContactPage;
	
	String sheetName = "Contacts";

	public ContactPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initalization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactLink();
	}

	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Validate the lable on Contact page")
	public void verifyContactPageLabelTest() throws IOException {
		String contactPageLabel = contactsPage.verifyContactPageLabel();
		Assert.assertEquals(contactPageLabel, "Contacts");
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getDataFromExcel")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate the add new Contact test")
	public void addNewContactTest(String firstName, String lastName, String middleName) throws IOException, InterruptedException {
		addNewContactPage = contactsPage.clickOnNewConatcButton();
		addNewContactPage.addNewContact(firstName, lastName, middleName);
		Thread.sleep(5000);
		homePage.clickOnContactLink();
	} 
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}








