package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddNewTaskPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TaskPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TaskPage taskPage;
	AddNewTaskPage addNewTaskPage;
	
	String sheetName = "Task";
	
	public TaskPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initalization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		taskPage = homePage.clickOnTaskLink();
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getDataFromExcel")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate the add new Task functionality")
	public void addnewtaskTest(String title) throws IOException, InterruptedException {
		addNewTaskPage = taskPage.clickOnNewTaskButton();
		addNewTaskPage.addNewTask(title);
		Thread.sleep(5000);
		homePage.clickOnTaskLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
