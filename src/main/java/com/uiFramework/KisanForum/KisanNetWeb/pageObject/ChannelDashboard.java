package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class ChannelDashboard {

	WebDriver driver;
	WaitHelper waitHelper;
	private final Logger log = LoggerHelper.getLogger(ChannelDashboard.class);
	
	@FindBy(xpath = "//span[@class='name namewithChannel']")
	WebElement channelNameInHeader;
	
	@FindBy(xpath = "//span[contains(text(),' public Channel')]")
	WebElement privacyType;
	
	@FindBy(xpath = "//a[@mattooltip='Chat with channel Owner!']")
	WebElement chatWithOwnerIcon;
	
	@FindBy(xpath = "//div[@class='loadingoverlay']")
	WebElement loadingOverlay;
	
	@FindBy(xpath = "//a[@class='font-bold-five']")
	WebElement channelNameInHeaderForAdmin;
	
	public ChannelDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		new TestBase().getNavigationScreen("ChannelDashboard",driver);
		TestBase.logExtentReport("Channel Dashboard Page Object Created");
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void clickOnChannelNameInHeader() {
		log.info("Clicking on channel name in header");
		logExtentReport("Clicking on channel name in header");
		waitHelper.waitForElementVisible(channelNameInHeader, ObjectReader.reader.getExplicitWait());
		channelNameInHeader.click();
	}
	
	public String getChannelPrivacy() {
		return privacyType.getText();
	}
	
	public void clickOnChatWithOwnerIcon() {
		log.info("Clicking on chat with owner icon");
		logExtentReport("Clicking on chat with owner icon");
		waitHelper.waitForElementVisible(chatWithOwnerIcon, 10);
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			chatWithOwnerIcon.click();
		}
		else {
			log.info("Left drawer is still loading");
		}
		
	}
	
	public void clickOnChannelNameInHeaderForAdmin() {
		log.info("Clicking on channel name in header for admin");
		logExtentReport("Clicking on channel name in header for admin");
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			channelNameInHeaderForAdmin.click();
		}
		else {
			log.info("Page is still loading");
		}
	}
	
	
}
