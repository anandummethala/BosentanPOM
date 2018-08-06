package com.bosentan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bosentan.qa.base.TestBase;

public class PatientAttestationFRPPage extends TestBase{

	@FindBy(xpath="//input[@id='termsChkBox']")
	WebElement CheckBox;
	
	@FindBy(xpath="//input[@id='patientAttestation.signatureName']")
	WebElement PatientSignature;
	
	
	
	//patientAttestation.signatureName
	
	public PatientAttestationFRPPage() throws IOException {
			PageFactory.initElements(driver, this);
		
	
}

	
	public String validatePatientAttestationTitle() {
		
		return driver.getTitle();
	}

	
	public ClassificationPage AttestationFRPPagedetails() throws InterruptedException, IOException {
		
		CheckBox.click();
		PatientSignature.sendKeys("Demein Martin");
		
		WebElement date = driver.findElement(By.xpath("//input[@id='patientAttestation.dateOfConsent']"));
		String dateval = "08/05/2018";
		selectElementByJS(date, driver, dateval);
		
		Thread.sleep(5000);
		WebElement nextbtn = driver.findElement(By.xpath("//button[@id='nextBtn']"));
		clickElementByJS(nextbtn, driver);
		
		return new ClassificationPage();
		
	}
	
	
	public static void selectElementByJS(WebElement element, WebDriver driver, String dateval) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value', '"+dateval+"');", element);
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
}

	
	
	
	
	

