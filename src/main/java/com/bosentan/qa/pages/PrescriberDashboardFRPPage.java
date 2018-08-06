package com.bosentan.qa.pages;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bosentan.qa.base.TestBase;

public class PrescriberDashboardFRPPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"enrollPat\"]")
	WebElement Patientenroll;
	
	public PrescriberDashboardFRPPage() throws IOException{
		PageFactory.initElements(driver, this);	
	}
	
	public String validatePrescriberDashboardPageTitle() {
		return driver.getTitle();
	
	}

	public PatientIntakeFRPPage EnrollPatient() throws IOException {
		Patientenroll.click();
		return new PatientIntakeFRPPage();
	}

}
