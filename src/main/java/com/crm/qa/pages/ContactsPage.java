package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	String dName;

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactPageLabel;
	
	@FindBy(xpath="//div[@class='item']/a")
	WebElement newButton;
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactPageLabel() {
		return contactPageLabel.getText();
	}

	public AddNewContactPage clickOnNewConatcButton() throws IOException {
		newButton.click();
		return new AddNewContactPage(); 
	}
}

