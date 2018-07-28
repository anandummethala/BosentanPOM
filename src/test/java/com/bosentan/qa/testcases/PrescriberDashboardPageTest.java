package com.bosentan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bosentan.qa.base.TestBase;
import com.bosentan.qa.pages.LoginPage;
import com.bosentan.qa.pages.PatientIntakePage;
import com.bosentan.qa.pages.PrescriberDashboardPage;

import junit.framework.Assert;

public class PrescriberDashboardPageTest extends TestBase{

	LoginPage loginpage;
	PrescriberDashboardPage prescriberdashboardpage;
	PatientIntakePage patientintakepage;
	
	public PrescriberDashboardPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws IOException {
		
		initialization();
		
		loginpage = new LoginPage();
		prescriberdashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
@Test(priority = 1)
	
	public void validatePrescriberDashboardPageTitleTest() throws IOException {
	
		String title = prescriberdashboardpage.validatePrescriberDashboardPageTitle();
		Assert.assertEquals("Bosentan REMS - My Dashboard", title);
	}
	
	@Test(priority = 2)
	public void EnrollPatientTest() throws IOException {
		
		
		patientintakepage = prescriberdashboardpage.EnrollPatient();
	}
	
	
	@AfterMethod
	
	public void tearDown() {
	driver.quit();
}
}