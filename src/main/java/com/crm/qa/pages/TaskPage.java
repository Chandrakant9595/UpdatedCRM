package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class TaskPage extends TestBase{

	@FindBy(xpath="//div[@class='item']/a")
	WebElement newButton;
	
	public TaskPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@Step("Step for click on New task Button")
	public AddNewTaskPage clickOnNewTaskButton() throws IOException {
		newButton.click();
		return new AddNewTaskPage();
	}
}

