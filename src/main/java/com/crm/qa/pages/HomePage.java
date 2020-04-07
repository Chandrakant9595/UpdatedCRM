package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

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
	
	@Step("Step for validate the tittle on Home page")
	public String verifyTheTittle() {
		return driver.getTitle();
	}

	@Step("Step for click on Contact link on Home page")
	public ContactsPage clickOnContactLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	@Step("Step for click on Company link on Home page")
	public CompaniesPage clickOnCompaniesLink() throws IOException {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	@Step("Step for click on Deals link on Home page")
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	@Step("Step for click on Task link on Home page")
	public TaskPage clickOnTaskLink() throws IOException {
		taskLink.click();
		return new TaskPage();
	}
	
	@Step("Step for verify the User name on Home page")
	public String verifyUserName() {
		return userName.getText();
	}
}
