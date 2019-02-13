package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;


public class ChannelChatWindow {

	WebDriver driver;
	WaitHelper waitHelper;
	private final Logger log = LoggerHelper.getLogger(ChannelDashboard.class);
	
	@FindBy(css = "textarea[placeholder='Type a message']")
	WebElement sendMessageTextBox;
	
	@FindBy(css = ".search-btn.fa.ib-m")
	WebElement searchButtonInChatWindow;
	
	@FindBy(css = ".zmdi.zmdi-attachment-alt")
	WebElement attachmentPinIcon;
	
	@FindBy(css = "#dashTopHeader > div.topRight > mat-icon:nth-child(3) > button")
	WebElement righDrawerChatWindow;		
	
	@FindBy(css = "button[type='submit']")
	WebElement sendTextMessageButton;		
	
	@FindAll(@FindBy(css = "button[class='mat-menu-item']"))
	List<WebElement> attachmentPinOptions;			
	
	@FindBy(css = "a[class='borderCircle text-center mat-fab mat-accent']")
	WebElement sendImageVideoButton;		
	
	@FindBy(css = "a[class='text-center mat-fab']")
	WebElement chatWithAdminButton;
	
	@FindBy(css = "i[class='zmdi zmdi-more-vert']")
	WebElement rightDrawer;
	
	@FindBy(css = "div[class='mat-menu-content ng-trigger ng-trigger-fadeInItems']")
	WebElement rightDrawerOptions;
	
	
	public ChannelChatWindow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		new TestBase().getNavigationScreen("ChannelChatWindow",driver);
		TestBase.logExtentReport("Channel Chat Window Page Object Created");
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
		
	public void clickOnRightDrawerMenu() {
		log.info("Clicking on Right drawer menu");
		logExtentReport("Clicking on Right drawer menu");
		waitHelper.waitForElementVisible(rightDrawer, ObjectReader.reader.getExplicitWait());
		rightDrawer.click();
	}
	
	public void clickOnSendMessageTextBox() {
		log.info("Clicking on Send MessageTextBox");
		logExtentReport("Clicking on Send MessageTextBox");
		waitHelper.waitForElementVisible(sendMessageTextBox, ObjectReader.reader.getExplicitWait());
		sendMessageTextBox.click();
	}	
	
	public void enterMessageInSendbox(String message) throws Exception {
		log.info("Entering message in send message box");
		logExtentReport("Entering message in send message box");
		waitHelper.waitForElementVisible(sendMessageTextBox, ObjectReader.reader.getExplicitWait());
		//sendMessageTextBox.click();
		sendMessageTextBox.sendKeys(message);
		Thread.sleep(2000);
	}
	
	public void clickOnSendButton() {
		log.info("Clicking on send button");
		logExtentReport("Clicking on send button");
		waitHelper.waitForElementVisible(sendTextMessageButton, ObjectReader.reader.getExplicitWait());
		sendTextMessageButton.click();
	}	
	
	public void clickOnAttachmentPin() {
		log.info("Clicking on attachment pin");
		logExtentReport("Clicking on attachment pin");
		waitHelper.waitForElementVisible(attachmentPinIcon, ObjectReader.reader.getExplicitWait());
		attachmentPinIcon.click();
	}
	
	public void clickAttachmentPinOption(String option) throws Exception {
				
		 for(WebElement We : attachmentPinOptions){
			 if(We.getText().equalsIgnoreCase(option)) {
				 Thread.sleep(1000);
				 We.click();
				 break;
			 }
		 }
	}
	
	public void selectAttachmentPinOption(String option) throws Exception {
		switch (option) {
		case "Camera":
			clickAttachmentPinOption(option);
			break;
			
		case "Image":
			clickAttachmentPinOption(option);
			break;
			
		case "Video":
			clickAttachmentPinOption(option);
			break;
			
		case "Audio":
			clickAttachmentPinOption(option);
			break;
			
		case "Location":
			clickAttachmentPinOption(option);
			break;

		default:
			break;
		}
	}
}
