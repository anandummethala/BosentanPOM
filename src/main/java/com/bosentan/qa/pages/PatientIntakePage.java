package com.bosentan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bosentan.qa.base.TestBase;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class PatientIntakePage extends TestBase{

	

	// page Factory OR:
	
		@FindBy(xpath = "//*[@id=\"patient.firstName\"]")
		WebElement FirstName;
		
		@FindBy(xpath = "//*[@id=\"patient.lastName\"]")
		WebElement LastName;
		
		@FindBy(xpath = "//*[@id=\"patient.birthDate\"]")
		WebElement DOB;

		
		@FindBy(xpath = "//*[@id=\"patient.residentialAddress.line1\"]")
		WebElement Address;
		
		@FindBy(xpath = "//*[@id=\"pracLocZipCode\"]")
		WebElement ZipCode;
		
		@FindBy(xpath = "//*[@id=\"patient.cellPhone.number\"]")
		WebElement Phone;
		
	
		
	
		
		
		
		
		public PatientIntakePage() throws IOException {
			PageFactory.initElements(driver, this);
		}
		
		public String validatePatientIntakeTitle() {
			
			return driver.getTitle();
		}
		
		
		public PatientAttestationPage PatientDetails(String fn, String ln, String dob, String add, String zip, String phn) throws IOException {
			
			FirstName.sendKeys(fn);
			LastName.sendKeys(ln);
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"patient.genderCode\"]")));
			select.selectByVisibleText(prop.getProperty("gender"));
			DOB.sendKeys(dob);
			Address.sendKeys(add);
			ZipCode.sendKeys(zip);
			Phone.sendKeys(phn);
			
			WebElement nextbtn = driver.findElement(By.xpath("//*[@id=\"patIntakeNextBtn\"]"));
			clickElementByJS(nextbtn, driver);
			
			
			
			return new PatientAttestationPage();
			
		}
		
		public static void clickElementByJS(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", element);
		}
}
