package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.VerificationHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class LeftDrawer {

	private final Logger log = LoggerHelper.getLogger(LeftDrawer.class);
	WebDriver driver;
	WaitHelper waitHelper;
	VerificationHelper verificationHelper;
	
	@FindBy(css = "a[class= 'clickUserProfile']")
	WebElement userProfileImage;
	
	@FindBy(xpath = "//div[@class='loadingoverlay']")
	WebElement loadingOverlay;
	
	public LeftDrawer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		verificationHelper = new VerificationHelper(driver);
		new TestBase().getNavigationScreen("LeftDrawer", driver);
		TestBase.logExtentReport("Left drawer object created");
		log.info("Left drawer object created");
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void clickOnUserProfileImage() {
		log.info("Clicking on user proifle image");
		logExtentReport("Clicking on user profile image");
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			waitHelper.waitForElementVisible(userProfileImage, ObjectReader.reader.getExplicitWait());
			userProfileImage.click();
		}
		else {
			log.info("Channle profile is still loading");
		}
		
		
	}
}
