package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.Status;
import com.google.common.base.Function;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class ChannelProfile {
	
	WebDriver driver;
	WaitHelper waitHelper;
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
	
	@FindBy(xpath = "//div[@class='loadingoverlay']")
	WebElement lodingOverlay;
	
	@FindBy(xpath = "//div[@class='toast-bottom-right toast-container']")
	WebElement overlayContainer;
	
	@FindBy(xpath = "//mat-sidenav-container[@class='welcome-content-area dashboardContainer mat-drawer-container mat-sidenav-container mat-drawer-transition mat-drawer-opened']")
	WebElement channelProfileDrawer;
	
	public ChannelProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElementVisible(channelName, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Channel Profile Page Object Created");
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void clickOnRightOptionMenu() throws Exception {
		log.info("Clicking on channel profile right option menu");
		logExtentReport("Clicking on channel profile right option menu");
		/*waitHelper.waitForElementVisible(rightOptionMenu, 10);
		Actions action = new Actions(driver);
		action.moveToElement(rightOptionMenu).build().perform();
		rightOptionMenu.click();	*/
		//waitHelper.waitForLoaderToDisappear();
		//waitHelper.waitForElementVisible(lodingOverlay, 20);
		if(!(waitHelper.WaitForElementDisapper(lodingOverlay))){
		//waitHelper.WaitForElementInVisibleWithPollingTime(lodingOverlay, 15, 2000);
		//waitHelper.waitForAllElementVisible(overlayContainer, ObjectReader.reader.getExplicitWait());
		//waitHelper.waitForAllElementVisible(rightOptionMenu, 15);
		//waitHelper.waitForElementVisible(rightOptionMenu, 10);
		//Thread.sleep(30000);
		//waitHelper.javaScriptWait(20);
		//waitHelper.waitForElementVisible(channelProfileDrawer, ObjectReader.reader.getExplicitWait());
		//waitHelper.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		rightOptionMenu.click();
		}
		else {
			log.info("Channle profile is still loading");
		}
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
	
}
