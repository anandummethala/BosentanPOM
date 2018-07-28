package com.bosentan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bosentan.qa.base.TestBase;
import com.bosentan.qa.pages.LoginPage;
import com.bosentan.qa.pages.PatientAttestationPage;
import com.bosentan.qa.pages.PatientIntakePage;
import com.bosentan.qa.pages.PrescriberDashboardPage;
import com.bosentan.qa.util.TestUtils;

import junit.framework.Assert;

public class PatientIntakePageTest extends TestBase{

	
	LoginPage loginpage;
	PrescriberDashboardPage prescriberdashboardpage;
	PatientIntakePage patientintakepage;
	PatientAttestationPage patientattestationpage;
	
	String sheetName = "Sheet1";
	
	
	public PatientIntakePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws IOException {
		
		initialization();
		
		loginpage = new LoginPage();
		prescriberdashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		patientintakepage =  prescriberdashboardpage.EnrollPatient();
		
		
	}
	
	
@Test(priority = 1)
	
	public void  validatePatientIntakeTitleTest() {
		
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals("Bosentan REMS - Patient Intake", title);
		
	}
	
	@DataProvider
	public Object[][] getBosentanTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		
		return data;
		
		
		
	}
	
	
	@Test(priority = 2, dataProvider="getBosentanTestData")
	
	public void PatientDetailsTest(String fname, String lname, String Dob, String addr, String Zip, String ph ) throws IOException, InterruptedException {
		patientintakepage.PatientDetails(fname, lname, Dob, addr, Zip, ph);
		Thread.sleep(5000);
		
		
	}
	
	
	@AfterMethod
	
	public void tearDown() {
	driver.quit();
}
	
}
