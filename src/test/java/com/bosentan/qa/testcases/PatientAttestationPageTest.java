package com.bosentan.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.bosentan.qa.pages.LoginPage;
import com.bosentan.qa.pages.PatientAttestationPage;
import com.bosentan.qa.pages.PatientIntakePage;
import com.bosentan.qa.pages.PrescriberDashboardPage;
import com.bosentan.qa.util.TestUtils;
import com.bosentan.qa.base.TestBase;

public class PatientAttestationPageTest extends TestBase{

	
	LoginPage loginpage;
	PrescriberDashboardPage prescriberdashboardpage;
	PatientIntakePage patientintakepage;
	PatientAttestationPage patientattestationpage;
	
	String sheetName = "Sheet1";
	
	
	public PatientAttestationPageTest() throws IOException {
		super();
	}
	
	
	
	
	@BeforeMethod()
	
	public void setup() throws IOException {
		
		initialization();
		
		loginpage = new LoginPage();
		prescriberdashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		patientintakepage =  prescriberdashboardpage.EnrollPatient();
		
		
		
	}
	
	@DataProvider
	public Object[][] getBosentanTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		
		return data;
		
		
		
	}
	
@Test(priority = 1, dataProvider="getBosentanTestData")
	
	public void PatientAttestationPage(String fname, String lname, String Dob, String addr, String Zip, String ph) throws IOException {
	
	patientattestationpage = patientintakepage.PatientDetails(fname, lname, Dob, addr, Zip, ph);
	}
	
@Test(priority = 2)
	
	public void  validatePatientIntakeTitleTest() {
		
		String title = patientattestationpage.validatePatientAttestationTitle();
		AssertJUnit.assertEquals("Bosentan REMS - Patient Attestation", title);
	}
}
