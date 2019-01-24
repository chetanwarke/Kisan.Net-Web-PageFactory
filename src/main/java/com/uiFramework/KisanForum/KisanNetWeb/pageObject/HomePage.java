package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.VerificationHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;



public class HomePage {

	WebDriver driver;
	WaitHelper waitHelper;
	VerificationHelper verificationHelper;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	
	@FindBy(css = ".chat-toolbar-list > mat-icon:nth-child(1)")
	WebElement discoverIcon;
	
	@FindBy(css = "mat-icon.mat-icon:nth-child(2)")
	WebElement notificationIcon;
	
	@FindBy(css = "mat-icon.mat-icon:nth-child(3)")
	WebElement rightOptionMenu;
	
	@FindAll(@FindBy(xpath = "//span[@class='limitChannelName ng-star-inserted']"))
	List<WebElement> channelList;
	
	@FindBy(xpath = "//span[@class='limitChannelName ng-star-inserted']")
	By allChannelList1;
	
	@FindBy(xpath = "//i[@class='zmdi zmdi-menu']")
	WebElement leftDrawerIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Invite to App')]")
	WebElement btnInviteToApp;
	
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement btnSearch;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement txtBoxSearch;
	
	@FindBy(xpath = "//div[@id='toast-container']")
	WebElement noChannelsFoundToast;
	
	public static By allChannelList = By.xpath("//span[@class='limitChannelName ng-star-inserted']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		verificationHelper = new VerificationHelper(driver);
		TestBase.logExtentReport("Home Page Object Created");
		new TestBase().getNavigationScreen("Homepage",driver);
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void clickOnDiscoverIcon() {
		log.info("Clicking on discover icon");
		logExtentReport("Clicking on discover icon");
		waitHelper.WaitForElementClickable(discoverIcon, 15);
		discoverIcon.click();
	}
	
	public void clickOnNotificationIcon() {
		log.info("Clicking on notification icon");
		logExtentReport("Clicking on notification icon");
		waitHelper.WaitForElementClickable(notificationIcon, 15);
		notificationIcon.click();
	}
	
	public void clickOnRightOptionMenu() {
		log.info("Clicking on right option menu");
		logExtentReport("Clicking on right option menu");
		waitHelper.waitForAllElement(allChannelList, 15);
		waitHelper.WaitForElementClickable(rightOptionMenu, 15);
		rightOptionMenu.click();
	}
	
	public void clickOnLeftDrawerIcon() {
		log.info("Clicking on left drawer");
		logExtentReport("Clicking on left drawer");
		waitHelper.waitForAllElement(allChannelList, ObjectReader.reader.getExplicitWait());
		waitHelper.WaitForElementClickable(leftDrawerIcon, 15);
		leftDrawerIcon.click();
	}
	
	public List<WebElement> getChannelList() {
		//waitHelper.waitForAllElement(allChannelList, 15);
		return channelList;
	}
	
	public void clickOnChannelName(String channelName) throws Exception {
		List<WebElement> channelList = getChannelList();
		for(int i=0; i<channelList.size(); i++) {
			//if(channelList.get(i).getText().equals(channelName)) {
				if(verificationHelper.readValueFromElement(channelList.get(i)).equals(channelName)) {	
				Thread.sleep(2000);
				channelList.get(i).click();
				Thread.sleep(2000);
				break;
			}
			else {
				System.out.println(verificationHelper.readValueFromElement(channelList.get(i)));
				i++;
			}
		}
	}
	
	public boolean isChannelExists(String channelName) throws Exception {
		List<WebElement> channelList = getChannelList();
		boolean presenceOfChannel = false;
		for(int i=0; i<channelList.size(); i++) {
			if(channelList.get(i).getText().equals(channelName)) {
				presenceOfChannel = true;
				break;
			}
			else {
				presenceOfChannel = false;
				i++;
			}
		}
		return presenceOfChannel;
	}
	
	public void clickOnSearchButton() {
		log.info("Clicking on search button from right option menu");
		logExtentReport("Clicking on search button from right option menu");
		waitHelper.WaitForElementClickable(btnSearch, 15);
		btnSearch.click();
	}
	
	public void clickOnInviteToAppButton() {
		log.info("Clicking on invite to app button from right option menu");
		logExtentReport("Clicking on invite to app button from right option menu");
		waitHelper.WaitForElementClickable(btnInviteToApp, 15);
		btnInviteToApp.click();
	}
	
	public void enterChannelNameInSearchBox(String channelName) throws Exception {
		log.info("Entering channel name in search box");
		logExtentReport("Entering channel name in search box");
		waitHelper.waitForElementVisible(txtBoxSearch, 10);
		txtBoxSearch.click();
		txtBoxSearch.sendKeys(channelName);
		Thread.sleep(2000);
	}
	
	public String getTitle() {
		log.info("Getting title of the page");
		logExtentReport("Getting title of the page");
		String title = verificationHelper.getTitle();
		return title;
	}
	
	public boolean verifyNoChannelsFoundToast() {
		return new VerificationHelper(driver).isDisplayed(noChannelsFoundToast);
	}
}
