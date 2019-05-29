package com.qa.capsulecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.capsulecrm.base.BasePage;
import com.qa.capsulecrm.util.ElementActions;

public class LoginPage extends BasePage
{
	WebDriver dr;
	//pagefactory--object repository
	
	@FindBy(how = How.CLASS_NAME, using = "formheading")
	WebElement loginlbl;
	
	@FindBy(how = How.ID, using = "login:usernameDecorate:username")
	WebElement usernametb;
	
	@FindBy(how = How.ID, using = "login:passwordDecorate:password")
	WebElement pwdtb;
	
	@FindBy(how = How.ID, using = "login:login")
	WebElement loginbtn;
	
	//page factory -- init elements
	
	public LoginPage(WebDriver dr)
	{
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	public String getLoginlbl()
	{
		return loginlbl.getText();
	}
	
	public HomePage loginToApp(String uname,String pwd)
	{
		//new WebDriverWait(dr,30).until(ExpectedConditions.visibilityOfElementLocated((By) usernametb));
		usernametb.clear();
		usernametb.sendKeys(uname);
		//new WebDriverWait(dr,30).until(ExpectedConditions.visibilityOfElementLocated((By) pwdtb));
		pwdtb.clear();
		pwdtb.sendKeys(pwd);
		//new WebDriverWait(dr,30).until(ExpectedConditions.visibilityOfElementLocated((By) loginbtn));
		loginbtn.click();
		return new HomePage();
	}
}
