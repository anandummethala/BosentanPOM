package com.bosentan.qa.pages;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bosentan.qa.base.TestBase;

public class LoginFRPPage extends TestBase{

	// page Factory OR:
	
	@FindBy(id = "userName")
	WebElement Username;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Loginbtn;
	
	
	//initializing the page objects
	public LoginFRPPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public PrescriberDashboardFRPPage login(String un, String pwd) throws IOException {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Loginbtn.click();
		
		return new PrescriberDashboardFRPPage();
	}
	
}
