package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class ContactsPage extends TestBase{
	
	String dName;

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactPageLabel;
	
	@FindBy(xpath="//div[@class='item']/a")
	WebElement newButton;
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Step for Verify the Contact page label on Contact page")
	public String verifyContactPageLabel() {
		return contactPageLabel.getText();
	}

	@Step("Step for Clicking on New contact button")
	public AddNewContactPage clickOnNewConatcButton() throws IOException {
		newButton.click();
		return new AddNewContactPage(); 
	}
}

