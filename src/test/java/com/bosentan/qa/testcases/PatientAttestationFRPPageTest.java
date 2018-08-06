package com.bosentan.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.bosentan.qa.pages.LoginFRPPage;
import com.bosentan.qa.pages.PatientAttestationFRPPage;
import com.bosentan.qa.pages.PatientIntakeFRPPage;
import com.bosentan.qa.pages.PrescriberDashboardFRPPage;
import com.bosentan.qa.util.TestUtils;
import com.bosentan.qa.base.TestBase;

public class PatientAttestationFRPPageTest extends TestBase{

	
	LoginFRPPage loginpage;
	PrescriberDashboardFRPPage prescriberdashboardpage;
	PatientIntakeFRPPage patientintakepage;
	PatientAttestationFRPPage patientattestationpage;
	
	String sheetName = "Sheet1";
	
	
	public PatientAttestationFRPPageTest() throws IOException {
		super();
	}
	
	
	
	
	@BeforeMethod()
	
	public void setup() throws IOException, InterruptedException {
		
		initialization();
		
		loginpage = new LoginFRPPage();
		prescriberdashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		patientintakepage =  prescriberdashboardpage.EnrollPatient();
		
			
	}

	@DataProvider
	public Object[][] getBosentanTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		
		return data;
		
		
		
	}
	
	
	@Test(priority = 1, dataProvider="getBosentanTestData")
	
	public void PatientDetailsTest(String fname, String lname, String Dob, String addr, String Zip, String ph ) throws IOException, InterruptedException {
		patientattestationpage= patientintakepage.PatientDetails(fname, lname, Dob, addr, Zip, ph);
		Thread.sleep(5000);
		
		patientattestationpage.AttestationFRPPagedetails();
	}
	
		
	
/*	
@Test(priority = 2)
	
	public void  validatePatientAttestationTitleTest() throws IOException, InterruptedException {
		
	    
	     
		String title = patientattestationpage.validatePatientAttestationTitle();
		Assert.assertEquals("Bosentan REMS - Patient Acknowledgement", title);
	}

@Test(priority = 3)

public void  AttestationPagedetailsTest() throws InterruptedException {
	
	patientattestationpage.AttestationPagedetails();
	
}*/

}
