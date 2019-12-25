package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.VerificationHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.javaScript.JavaScriptHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.window.WindowHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class LeftDrawer {

	private final Logger log = LoggerHelper.getLogger(LeftDrawer.class);
	WebDriver driver;
	WaitHelper waitHelper;
	VerificationHelper verificationHelper;
	JavaScriptHelper javaScriptHelper;
	WindowHelper windowHelper;
	
	@FindBy(css = "a[class= 'clickUserProfile']")
	WebElement userProfileImage;
	
	@FindBy(xpath = "//div[@class='loadingoverlay']")
	WebElement loadingOverlay;
	
	@FindBy(xpath = "//a[contains(text(),'View All')]")
	WebElement btnViewAll;
	
	@FindAll(@FindBy(xpath = "//mat-list-item[@class='pad-tb-sm mat-list-item mat-list-item-avatar mat-list-item-with-avatar']"))
	List<WebElement> allChannelList1;
	
	@FindBy(xpath = "//h2/child::span[@class='ng-star-inserted']")
	WebElement totalChannels;
	
	@FindBy(xpath = "//mat-dialog-content[@class='mat-dialog-content']")
	WebElement channelListScrollbar;
	
	@FindBy(xpath = "//a[contains(text(),'Channel Profile')]")
	WebElement btnChannelProfile;
	
	@FindBy(xpath = "//span[contains(text(),'About App')]")
	WebElement optionAboutApp;
	
	@FindBy(xpath = "//span[contains(text(),'Support')]")
	WebElement optionSupport;
	
	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	WebElement optionLogout;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement btnYesOnPopup;
	
	@FindBy(xpath = "//button[contains(text(),'No')]")
	WebElement btnNoOnPopup;
	
	@FindBy(xpath = "//span[contains(text(),'Discover')]")
	WebElement optionDiscover;
	
	@FindBy(xpath = "//span[contains(text(),'My Channel')]")
	WebElement optionMyChannel;
	
	public static By allChannelList = By.xpath("//h3[@class='font-bold-five mat-line']");

	
	public LeftDrawer(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
		waitHelper = new WaitHelper(driver);
		verificationHelper = new VerificationHelper(driver);
		javaScriptHelper = new JavaScriptHelper(driver);
		windowHelper = new WindowHelper(driver);
		//new TestBase().getNavigationScreen("LeftDrawer", driver);
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
	
	public int getTotalChannlesFollowed() {
		log.info("Getting total channels followed");
		logExtentReport("Getting total channels followed");
		System.out.println(totalChannels.getText());
		String substring = totalChannels.getText().substring(2);
		int totalChannelCount = Integer.parseInt(substring);
		return totalChannelCount;
	}
	
	public void clickOnViewAllButton() {
		log.info("Clicking on view all button");
		logExtentReport("Clicking on view all button");
		waitHelper.WaitForElementClickable(btnViewAll, ObjectReader.reader.getExplicitWait());
		btnViewAll.click();
	}
	
	public void clickOnChannelName(String channelName, int totalChannelCount) throws Exception {
		log.info("Clicking on channel name in view all channels list");
		logExtentReport("Clicking on channel name in view all channels list");
		waitHelper.waitForAllElement(allChannelList, ObjectReader.reader.getExplicitWait());
		
		for(int i = 0; i < totalChannelCount; i++) {
			javaScriptHelper.scrollIntoView(allChannelList1.get(allChannelList1.size()-1));
			waitHelper.waitForAllElement(allChannelList, ObjectReader.reader.getExplicitWait());
			//totalChannels = allChannelList1.size();
			i = allChannelList1.size();
		}
		
		for(int i =0; i<totalChannelCount;i++) {
			if(allChannelList1.get(i).getText().equals(channelName)){
				allChannelList1.get(i).click();
				break;
			}
			else {
				continue;
				}
				
			}
		
		Thread.sleep(5000);
	}
	
	public void clickOnChannelProfileButton() {
		log.info("Clicking on channel profile button");
		logExtentReport("Clicking on channel profile button");
		waitHelper.WaitForElementClickable(btnChannelProfile, ObjectReader.reader.getExplicitWait());
		btnChannelProfile.click();
	}
	
	public void clickOnAboutAppOption() {
		log.info("Clicking on about app option");
		logExtentReport("Clicking on about app option");
		waitHelper.WaitForElementClickable(optionAboutApp, ObjectReader.reader.getExplicitWait());
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			optionAboutApp.click();
		}
		else {
			log.info("Left drawer is still loading");
		}
	}
	
	public void clickOnSupportOption() {
		log.info("Clicking on support option");
		logExtentReport("Clicking on support option");
		waitHelper.WaitForElementClickable(optionSupport, ObjectReader.reader.getExplicitWait());
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			optionSupport.click();
		}
		else {
			log.info("Left drawer is still loading");
		}
	}
	
	public void clickOnLogoutOption() {
		log.info("Clicking on logout option");
		logExtentReport("Clicking on logout option");
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			javaScriptHelper.scrollIntoView(optionLogout);
			waitHelper.WaitForElementClickable(optionLogout, ObjectReader.reader.getExplicitWait());
			optionLogout.click();
		}
		else {
			log.info("Left drawer is still loading");
		}
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
	
	public void clickOnDiscoverOption() {
		log.info("Clicking on discover option");
		logExtentReport("Clicking on discover option");
		waitHelper.WaitForElementClickable(optionDiscover, ObjectReader.reader.getExplicitWait());
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			optionDiscover.click();
		}
		else {
			log.info("Left drawer is still loading");
		}
	}
	
	public void clickOnMyChannelOption() throws Exception {
		log.info("Clicking on my channel option");
		logExtentReport("Clicking on my channel option");
		waitHelper.WaitForElementClickable(optionMyChannel, ObjectReader.reader.getExplicitWait());
		/*if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			optionMyChannel.click();
		}
		else {
			log.info("Left drawer is still loading");
		}*/    //Commenting for temp purpose to check if the issue resolved
		optionMyChannel.click(); // Adding for temp purpose to check if issue resolved
		Thread.sleep(1000);
	}
}
