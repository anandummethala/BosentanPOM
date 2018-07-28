package com.bosentan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bosentan.qa.base.TestBase;
import com.bosentan.qa.pages.LoginPage;
import com.bosentan.qa.pages.PrescriberDashboardPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	PrescriberDashboardPage prescriberdashboardpage;
	
	
	
	public LoginPageTest() throws IOException{
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws IOException {
		
		initialization();
		
		loginpage = new LoginPage();
		
	}
	
	
	@Test(priority = 1)
	
	public void validateLoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals("Bosentan REMS - Sign in", title);
	}
	
	
    @Test(priority = 2)
	
	public void loginTest() throws IOException  {
	prescriberdashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
    @AfterMethod

public void tearDown() {
		
		driver.quit();
		
	}

}
