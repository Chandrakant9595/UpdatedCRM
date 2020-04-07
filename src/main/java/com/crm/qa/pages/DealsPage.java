package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class DealsPage extends TestBase{

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement dealsPageLabel;
	
	public DealsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Step for verfiy the Deal label on Deal page")
	public String verfiyDealsLabel() {
		return dealsPageLabel.getText();
	}

}
