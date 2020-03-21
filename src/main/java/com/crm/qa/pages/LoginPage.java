package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//define all web elements
	@FindBy(xpath = "//input[@name='email']")
	WebElement userNmae;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	//initialized the all web-elements in counstructor 
	public LoginPage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);
	}
	
	//define actions
	public String validateTheTittle() {
		return driver.getTitle();
	}
	
	public String validateTheURL() {
		return driver.getCurrentUrl();
	}
	
	public HomePage login(String un, String pwd) throws IOException, InterruptedException {
		userNmae.clear();
		userNmae.sendKeys(un);
		
		password.clear();
		password.sendKeys(pwd);
		
		loginButton.click();
		
		return new HomePage();
	}

	
}






