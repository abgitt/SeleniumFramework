package com.qa.capsulecrm.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.capsulecrm.base.BasePage;
import com.qa.capsulecrm.listeners.ExtentReportListener;
import com.qa.capsulecrm.pages.LoginPage;
import com.qa.capsulecrm.util.CommonUtil;

public class LoginPageTest 
{
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.MediumWait();
		loginPage = new LoginPage(driver);
	}
	
	@Test(description="To check are we there in login page or not!!!!")
	public void validateLoginPageTest()
	{
		BasePage.extentTest.log(Status.INFO,"Validating login page by checking login lable" );
		Assert.assertEquals(loginPage.getLoginlbl(), "Log In");
		BasePage.extentTest.log(Status.PASS,"Lable found with text :: "+ loginPage.getLoginlbl());
	}
	@Test(description="To Validate login functionality working properly or not")
	public void validateLoginFunctionalityTest()
	{
		BasePage.extentTest.log(Status.INFO,"Validating login functionality by performing login " );
		loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
		BasePage.extentTest.log(Status.PASS,"Lable found with text :: "+ loginPage.getLoginlbl());
	}
	
	@AfterMethod
	public void tearDown() {
		//quit the browser
		driver.quit();
	}
}
