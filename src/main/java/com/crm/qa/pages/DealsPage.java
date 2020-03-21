package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement dealsPageLabel;
	
	public DealsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verfiyDealsLabel() {
		return dealsPageLabel.getText();
	}

}
