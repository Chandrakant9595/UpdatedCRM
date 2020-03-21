package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//div[@class='right menu']/span[1]")
	WebElement userName;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[3]/span")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[text()='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement taskLink;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTheTittle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public CompaniesPage clickOnCompaniesLink() throws IOException {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink() throws IOException {
		taskLink.click();
		return new TaskPage();
	}
	
	public String verifyUserName() {
		return userName.getText();
	}
}
