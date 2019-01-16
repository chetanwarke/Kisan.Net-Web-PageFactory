package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.VerificationHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class InvitePage {

	WebDriver driver;
	WaitHelper waitHelper;
	private final Logger log = LoggerHelper.getLogger(InvitePage.class);
	
	@FindBy(xpath = "//i[@class='zmdi zmdi-arrow-left']")
	WebElement btnBack;
	
	@FindBy(xpath = "//a[contains(text(),'Skip')]")
	WebElement btnSkip;
	
	@FindBy(xpath = "//p[contains(text(),' Invite using Mobile Number.')]")
	WebElement btnInviteUsingMobile;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement btnInviteUsingCSV;
	
	@FindBy (xpath = "//a[contains(text(),' Install our app')]")
	WebElement btnInstallAndroidApp;
	
	@FindBy (xpath = "//p[contains(text(),' Upload a CSV')]")
	WebElement btnUploadCSV;
	
	@FindBy(xpath = "//a[contains(text(),'Channel Dashboard')]")
	WebElement btnChannelDashboard;
	
	@FindBy(id = "mobilenumber")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//span[contains(text(),'Send Invite')]")
	WebElement btnSendInvite;
	
	@FindBy(xpath = "//a[contains(text(),'Send Invite')]")
	WebElement btnSendInviteCSV;
	
	@FindBy(xpath = "//p[contains(text(),' Upload a CSV file of your contacts ')]")
	WebElement textUploadCSVButton;
	
	@FindBy(xpath = "//div[@id='toast-container']")
	WebElement successToast;
	
	@FindBy(xpath = "//span[contains(text(),'Please Enter 10 digit Mobile Number')]")
	WebElement mobileValidationError;
	
	
	public InvitePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Invite page object created");	
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO,s1);
	}
	
	public void clickOnBackButton() {
		log.info("Clicking on back button on invite page");
		logExtentReport("Clicking on back button on invite page");
		waitHelper.waitForElementVisible(btnBack, 10);
		btnBack.click();
	}
	
	public void clickOnSkipkButton() {
		log.info("Clicking on skip button on invite page");
		logExtentReport("Clicking on skip button on invite page");
		waitHelper.waitForElementVisible(btnSkip, 10);
		btnSkip.click();
	}
	
	public void clickOnInviteUsingMobile() {
		log.info("Clicking on manual invite button on invite page");
		logExtentReport("Clicking on manual invite button on invite page");
		waitHelper.waitForElementVisible(btnInviteUsingMobile, 10);
		btnInviteUsingMobile.click();
	}
	
	public void clickOnUploadCSVFile() {
		log.info("Clicking on upload csv button on invite page");
		logExtentReport("Clicking on upload csv button on invite page");
		waitHelper.WaitForElementClickable(textUploadCSVButton, 10);
		btnInviteUsingCSV.click();
	}
	
	public void clickOnUploadCSV() {
		log.info("Clicking on upload csv button on invite page");
		logExtentReport("Clicking on upload csv button on invite page");
		waitHelper.waitForElementVisible(btnUploadCSV, 10);
		btnUploadCSV.click();
	}
	
	public void clickOnDownloadAndroidApp() {
		log.info("Clicking on download android app link on invite page");
		logExtentReport("Clicking on download android app link on invite page");
		waitHelper.waitForElementVisible(btnInstallAndroidApp, 10);
		btnInstallAndroidApp.click();
	}
	
	public void clickOnChannelDashboardButton() {
		log.info("Clicking on channel dashboard button on invite page");
		logExtentReport("Clicking on channel dashboard button on invite page");
		waitHelper.waitForElementVisible(btnChannelDashboard, 10);
		btnChannelDashboard.click();
	}
	
	public void clickOnSendInviteButton() {
		log.info("Clicking on send invite button on invite page");
		logExtentReport("Clicking on send invite button on invite page");
		waitHelper.waitForElementVisible(btnSendInvite, 10);
		btnSendInvite.click();
	}
	
	public void clickOnSendCSVInviteButton() {
		log.info("Clicking on send invite button on invite page");
		logExtentReport("Clicking on send invite button on invite page");
		waitHelper.waitForElementVisible(btnSendInviteCSV, 10);
		btnSendInviteCSV.click();
	}
	
	/*public void clickOnUploadCSVOption() {
		log.info("Clicking on upload a csv file button on invite page");
		logExtentReport("Clicking on upload a csv file button on invite page");
		waitHelper.WaitForElementClickable(btnSendInviteCSV, 10);
		btnSendInviteCSV.click();
	}*/
	
	public void enterMobileNumber(String mobileNumber) {
		log.info("entering mobile number...."+mobileNumber);
		logExtentReport("entering mobile number...."+mobileNumber);
		waitHelper.waitForElementVisible(this.mobileNumber, 10);
		this.mobileNumber.click();
		this.mobileNumber.sendKeys(mobileNumber);
	}
	
	public boolean verifyInviteSuccessToast() {
		return new VerificationHelper(driver).isDisplayed(successToast);
	}

	public boolean verifyMobileValidationMessage() {
		return new VerificationHelper(driver).isDisplayed(mobileValidationError);
	}
}
