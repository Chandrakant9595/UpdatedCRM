package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class CompaniesPage extends TestBase{

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement compniesPageLabel;
	
	@FindBy(xpath="//div[@class='item']/a")
	WebElement newButton;
	
	public CompaniesPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@Step("Step for verify the Company label")
	public String verfiyCompaniesLabel() {
		return compniesPageLabel.getText();
	}
	
	@Step("Step for Click on New Company button")
	public AddNewCompanyPage clickOnNewCompanyButton() throws IOException {
		newButton.click();
		return new AddNewCompanyPage();
	}
}


