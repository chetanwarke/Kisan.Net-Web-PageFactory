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

public class ChannelProfile {
	
	WebDriver driver;
	WaitHelper waitHelper;
	VerificationHelper verificationHelper;
	private final Logger log = LoggerHelper.getLogger(ChannelProfile.class);
	
	@FindBy(css = "i[class='zmdi zmdi-more-vert']")
	WebElement rightOptionMenu1;
	
	@FindBy(xpath = "//div[@class='rightsideIconDropdown']/child::button")
	WebElement rightOptionMenu;
	
	@FindBy(css = "i[class='zmdi zmdi-close']")
	WebElement btnClose;
	
	@FindBy(xpath = "//h4[@class='mrgn-t-lg mrgn-b-xs font-bold-three']")
	WebElement channelName;
	
	@FindBy(xpath = "//a[contains(text(),'Edit Profile')]")
	WebElement btnEditProfile;
	
	@FindBy(xpath = "//a[contains(text(),'Invite to Channel')]")
	WebElement btnInviteToChannel;
	
	@FindBy(xpath = "//a[contains(text(),'Invite to Channel')]")
	WebElement btnBlockedFollowers;
	
	@FindBy(xpath = "//a[contains(text(),'Unfollow Channel')]")
	WebElement btnUnfollowChannel;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement btnYesOnPopup;
	
	@FindBy(xpath = "//button[contains(text(),'No')]")
	WebElement btnNoOnPopup;
	
	@FindBy(xpath = "//div[@class='loadingoverlay']")
	WebElement loadingOverlay;
	
	@FindBy(xpath = "//div[@class='toast-bottom-right toast-container']")
	WebElement overlayContainer;
	
	@FindBy(xpath = "//mat-sidenav-container[@class='welcome-content-area dashboardContainer mat-drawer-container mat-sidenav-container mat-drawer-transition mat-drawer-opened']")
	WebElement channelProfileDrawer;
	
	@FindBy(xpath = "//i[@class='zmdi zmdi-arrow-right']")
	WebElement btnFollow;
	
	@FindBy(xpath = "//div[@aria-label='Channel Followed successfully.']")
	WebElement channelFollowedToast;
	
	@FindBy(xpath = "//div[@aria-label='Channel left successfully.']")
	WebElement channelUnfollowedToast;
	
	
	
	public ChannelProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		verificationHelper = new VerificationHelper(driver);
		//waitHelper.waitForElementVisible(channelName, ObjectReader.reader.getExplicitWait());
		//new TestBase().getNavigationScreen("ChannelProfile",driver);
		TestBase.logExtentReport("Channel Profile Page Object Created");
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void clickOnRightOptionMenu() throws Exception {
		Thread.sleep(2000);
		log.info("Clicking on channel profile right option menu");
		logExtentReport("Clicking on channel profile right option menu");
		if(!(waitHelper.WaitForElementDisapper(loadingOverlay))){
		rightOptionMenu.click();
		}
		else {
			log.info("Channle profile is still loading");
		}
		//waitHelper.setImplicitWait(20, TimeUnit.SECONDS);
	}

	public void clickOnCloseButton() {
		log.info("Clicking on close button");
		logExtentReport("Clicking on close button");
		waitHelper.waitForElementVisible(btnClose, 10);
		btnClose.click();
	}
	
	public String getChannelName() {
		log.info("Clicking on close button");
		logExtentReport("Clicking on close button");
		waitHelper.waitForElementVisible(channelName, 10);
		return channelName.getText();	
	}
	
	public void clickOnEditProfileOption() {
		log.info("Clicking on edit channel profile");
		logExtentReport("Clicking on edit channel profile");
		waitHelper.waitForElementVisible(btnEditProfile, 10);
		btnEditProfile.click();	
	}
	
	public void clickOnInviteToChannelOption() {
		log.info("Clicking on invite to channel");
		logExtentReport("Clicking on edit invite to channel");
		waitHelper.waitForElementVisible(btnInviteToChannel, 10);
		btnInviteToChannel.click();	
	}
	
	public void clickOnBlockedFollowersOption() {
		log.info("Clicking on blocked followers");
		logExtentReport("Clicking on blocked followers");
		waitHelper.waitForElementVisible(btnBlockedFollowers, 10);
		btnBlockedFollowers.click();	
	}
	
	public void clickOnUnfollowChannelOption() throws Exception {
		log.info("Clicking on unfollow button");
		logExtentReport("Clicking on unfollow button");
		waitHelper.waitForElementVisible(btnUnfollowChannel, ObjectReader.reader.getExplicitWait());
		btnUnfollowChannel.click();
		Thread.sleep(2000);
	}
	
	public void clickOnYesButtonOnPopup() {
		log.info("Clicking on Yes button on popup");
		logExtentReport("Clicking on Yes button on popup");
		waitHelper.waitForElementVisible(btnYesOnPopup, ObjectReader.reader.getExplicitWait());
		btnYesOnPopup.click();
	}
	
	public void clickOnNoButtonOnPopup() {
		log.info("Clicking on No button on popup");
		logExtentReport("Clicking on No button on popup");
		waitHelper.waitForElementVisible(btnNoOnPopup, ObjectReader.reader.getExplicitWait());
		btnNoOnPopup.click();
	}
	
	public void clickOnFollowButton() {
		log.info("Clicking on follow button");
		logExtentReport("Clicking on follow button");
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			btnFollow.click();
		}
		else {
			log.info("Channle profile is still loading");
		}
				
	}
	
	public boolean verifyChannelFollowedToast() {
		log.info("Verifying channel followed toast");
		logExtentReport("Verifying channel followed toast");
		return new VerificationHelper(driver).isDisplayed(channelFollowedToast);
	}
	
	public boolean verifyChannelUnfollowedToast() throws Exception {
		log.info("Verifying channel unfollowed toast");
		logExtentReport("Verifying channel unfollowed toast");
		boolean status = false;
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			status = verificationHelper.isDisplayed(channelUnfollowedToast);
			Thread.sleep(2000);
			return status;
		}
		else {
			log.info("Channle profile is still loading");
			return status;
		}
	}
}
