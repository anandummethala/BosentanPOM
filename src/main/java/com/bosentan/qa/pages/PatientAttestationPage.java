package com.bosentan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.bosentan.qa.base.TestBase;

public class PatientAttestationPage extends TestBase{

	public PatientAttestationPage() throws IOException {
			PageFactory.initElements(driver, this);
		
	
}

	
	public String validatePatientAttestationTitle() {
		
		return driver.getTitle();
	}

}

	
	
	
	
	

