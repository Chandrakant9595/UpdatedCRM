package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AddNewCompanyPage extends TestBase{

	@FindBy(xpath="//input[@name='name']")
	WebElement compName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	public AddNewCompanyPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void addNewCompany(String cName) {
		compName.sendKeys(cName);
		saveButton.click();
	}
}
