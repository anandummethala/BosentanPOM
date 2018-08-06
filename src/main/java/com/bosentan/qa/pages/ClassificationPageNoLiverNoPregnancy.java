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

public class ClassificationPageNoLiverNoPregnancy extends TestBase {

	
	
	
	@FindBy(xpath = "//input[@id='pregnancyTestCompleted2']")
	WebElement pregnancytest;
	
	@FindBy(xpath = "//input[@id='patientCounselingCompleted']")
	WebElement Patientcounseling;
	
	
	@FindBy(xpath="//input[@id='registrationAttestation.signatureName']")
	WebElement PrescriberSignature;
	
	public ClassificationPageNoLiverNoPregnancy() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public FinishPage enterClassification() throws InterruptedException {
		
		WebElement livertest = driver.findElement(By.xpath("//input[@name ='liverTestCompleted2' and @value='false']"));
		clickElementByJS2(livertest, driver);
		Select select = new Select(driver.findElement(By.xpath("//select[@id='patientCategory']")));
		select.selectByVisibleText("Female Reproductive Potential (FRP)"); 
		pregnancytest.click();
		Patientcounseling.click();
		PrescriberSignature.sendKeys("ARNOLD PALLAY");
		
		
		WebElement date = driver.findElement(By.xpath("//input[@id='registrationAttestation.dateOfConsent']"));
		String dateval = "08/05/2018";
		selectElementByJS(date, driver, dateval);
		
		Thread.sleep(5000);
		WebElement nextbtn = driver.findElement(By.xpath("//button[@id='nextBtn']"));
		clickElementByJS1(nextbtn, driver);
		
		
		
		
		return new FinishPage();
	}
	

	public static void selectElementByJS(WebElement element, WebDriver driver, String dateval) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value', '"+dateval+"');", element);
	}
	
	public static void clickElementByJS1(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void clickElementByJS2(WebElement element1, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element1);
	}
}
