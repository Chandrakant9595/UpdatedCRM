package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class AddNewTaskPage extends TestBase{

	@FindBy(xpath="//input[@name='title']")
	WebElement title;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	public AddNewTaskPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@Step("Step for add new Task")
	public void addNewTask(String tit) {
		title.sendKeys(tit);
		saveButton.click();
	}
}
