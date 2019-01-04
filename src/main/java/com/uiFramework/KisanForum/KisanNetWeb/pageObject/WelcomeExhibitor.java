package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class WelcomeExhibitor {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ShoppinCartSummaryPage.class);
	WaitHelper waitHelper;
	
	public static By registerButton = By.xpath("//span[contains(text(),'REGISTER')]");
	public static By skipButton = By.xpath("//div[contains(text(),'SKIP NOW')]");
	public static By backButton = By.xpath("//div[@class='backBtn']");
	
	public WelcomeExhibitor(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementVisible(driver.findElement(backButton),ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Welcome Exhibitor Page Object Created");
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void clickOnskipButton() {
		log.info("clicked on skip button...");
		logExtentReport("clicked on skip button...");
		waitHelper.waitForElementVisible(driver.findElement(skipButton), 10);
		driver.findElement(skipButton).click();
	}
	
}
