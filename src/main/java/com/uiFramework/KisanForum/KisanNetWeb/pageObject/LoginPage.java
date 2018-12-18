package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;


public class LoginPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ShoppinCartSummaryPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath ="//input[@type='tel']")
	WebElement mobileNumberTextBox;
	
	@FindBy(xpath = "//button[starts-with(@id,'u_')]")
	WebElement nextButton;
	
	@FindBy(xpath = "//div[contains(text(),'Verify your phone number')]/parent::div/following-sibling::div[1]")
	WebElement closeButton;
	
	@FindBy(xpath = "//input[@type='tel']")
	WebElement enterYourCode;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement continueButton;
	
	@FindBy(xpath = "/html/body/div[1]/iframe")
	WebElement facebookLoginWindow;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(mobileNumberTextBox,ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Kisan.Net Login Page Object Created");
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void switchToFacebookFrame() {
		log.info("Switching to facebook login window");
		logExtentReport("Switching to facebook login window");
		waitHelper.waitForframeToBeAvailableAndSwitchToIt(facebookLoginWindow, 10);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		log.info("entering mobile number...."+mobileNumber);
		logExtentReport("entering mobile number...."+mobileNumber);
		this.mobileNumberTextBox.sendKeys(mobileNumber);
	}
	
	public void clickOnNextButton() {
		log.info("clicked on next button...");
		logExtentReport("clicked on next button...");
		nextButton.click();
	}
	
	public void clickOnContinueButton() {
		log.info("clicked on continue button...");
		logExtentReport("clicked on continue button...");
		waitHelper.WaitForElementClickable(continueButton, 40);
		continueButton.click();
	}
	
	public void clickOnCloseButton() {
		log.info("Closed the visitor login popup");
		logExtentReport("Closed the visitor login popup");
		List<WebElement> closeBtn = (List<WebElement>) closeButton;
		closeBtn.get(2).click();
	}
	
	
}
