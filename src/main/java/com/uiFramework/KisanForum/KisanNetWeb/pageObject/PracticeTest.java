package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.utils.FileUtil;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.FirefoxBrowser;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class PracticeTest {

	
		
	private final Logger log = LoggerHelper.getLogger(SupportPage.class);	
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

	

	public PracticeTest(WebDriver driver, WaitHelper waitHelper) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		new TestBase().getNavigationScreen("Support Page", driver);
		TestBase.logExtentReport("Support page object created");
		log.info("Support page object created");
	}
	
	public void clickOnUserProfileImage() {
		log.info("Clicking on user proifle image");
		logExtentReport("Clicking on user profile image");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(companyEmail));
		wait.pollingEvery(Duration.ofSeconds(2));
		FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
		fluentwait.ignoring(NoSuchElementException.class);
	
	}

	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
	
	
}
