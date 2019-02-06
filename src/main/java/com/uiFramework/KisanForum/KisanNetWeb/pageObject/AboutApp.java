package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class AboutApp {
	
	private final Logger log = LoggerHelper.getLogger(AboutApp.class);	
	WebDriver driver;
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//p[contains(text(),'We would be happy to help you.')]")
	WebElement infoMessage;
	
	@FindBy(xpath = "//h3[contains(text(),'Namaskar!')]")
	WebElement namaskarText;
	
	@FindBy(xpath = "//p[contains(text(),'App Version 6.0')]")
	WebElement appVersion;
	
	public AboutApp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		new TestBase().getNavigationScreen("About App", driver);
		TestBase.logExtentReport("About app page object created");
		log.info("About app page object created");
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, "s1");
	}

	public boolean verifyInfoMessage(String info) {
		if(infoMessage.getText().equals(info)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyNamaskarText(String namaskar) {
		if(namaskarText.getText().equals(namaskar)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyAppVersion(String version) {
		if(appVersion.getText().equals(version)) {
			return true;
		}
		else {
			return false;
		}
	}
}
