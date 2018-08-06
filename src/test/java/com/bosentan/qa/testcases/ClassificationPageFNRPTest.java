package com.bosentan.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bosentan.qa.base.TestBase;
import com.bosentan.qa.pages.ClassificationPage;
import com.bosentan.qa.pages.LoginFRPPage;
import com.bosentan.qa.pages.PatientAttestationFRPPage;
import com.bosentan.qa.pages.PatientIntakeFRPPage;
import com.bosentan.qa.pages.PrescriberDashboardFRPPage;
import com.bosentan.qa.util.TestUtils;

public class ClassificationPageFNRPTest extends TestBase{

	LoginFRPPage loginpage;
	PrescriberDashboardFRPPage prescriberdashboardpage;
	PatientIntakeFRPPage patientintakepage;
	PatientAttestationFRPPage patientattestationpage;
	ClassificationPage classificationpage;
	
	
	String sheetName = "Sheet1";
	
	public ClassificationPageFNRPTest() throws IOException {
		super();
	
		
		
	}

	@BeforeMethod
	
	public void setup() throws IOException {
		
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
		
		classificationpage = patientattestationpage.AttestationFRPPagedetails();
		Thread.sleep(5000);
		classificationpage.enterClassification();
	}
}
