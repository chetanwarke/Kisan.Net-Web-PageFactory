package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class SupportPage {

	private final Logger log = LoggerHelper.getLogger(AboutApp.class);	
	WebDriver driver;
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//h3[contains(text(),'Namaskar!')]")
	WebElement namaskarText;
	
	@FindBy(xpath = "//span[contains(text(),'app@kisan.com')]")
	WebElement companyEmail;
	
	@FindBy(xpath = "//span[contains(text(),'020-3025-2020')]")
	WebElement companyPhoneNumber;
	
	@FindBy(xpath = "//p[contains(text(),'We would be happy to help you.')]")
	WebElement helpText;
	
	
	
	public SupportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		new TestBase().getNavigationScreen("Support Page", driver);
		TestBase.logExtentReport("Support page object created");
		log.info("Support page object created");
	}
	
	public boolean verifyNamaskarText(String namaskar) {
		if(namaskarText.getText().equals(namaskar)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyCompanyEmail(String email) {
		if(companyEmail.getText().equals(email)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyCompanyPhoneNumber(String phoneNumber) {
		if(companyPhoneNumber.getText().equals(phoneNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyhelpTexxt(String helpText) {
		if(this.helpText.getText().equals(helpText)) {
			return true;
		}
		else {
			return false;
		}
	}
}
