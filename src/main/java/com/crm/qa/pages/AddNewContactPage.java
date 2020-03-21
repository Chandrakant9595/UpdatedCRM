package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class AddNewContactPage extends TestBase{
	
	TestUtil testUtil;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement middleName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	public AddNewContactPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void addNewContact(String fName, String lName, String mName) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		middleName.sendKeys(mName);
		saveButton.click();
		}

}
