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
	
	@FindBy(xpath = "//div[@class='loadingoverlay']")
	WebElement loadingOverlay;
	
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
	
	@FindBy(xpath = "//a[contains(text(),'Camera')]")
	WebElement cameraOption;
	
	@FindBy(xpath = "//a[contains(text(),'Image')]")
	WebElement imageOption;
	
	@FindBy(xpath = "//a[contains(text(),'Video')]")
	WebElement videoOption;
	
	@FindBy(xpath = "//a[contains(text(),'Audio')]")
	WebElement audioOption;
	
	@FindBy(xpath = "//div[contains(text(),'Record a Audio')]")
	WebElement recordAudioOption;
	
	@FindBy(xpath = "//span[contains(text(),'Choose Audio from gallery')]")
	WebElement chooseAudioOption;
	
	@FindBy(xpath = "//a[contains(text(),'Location')]")
	WebElement locationOption;
	
	@FindBy(xpath = "//a[contains(text(),'Document')]")
	WebElement documentOption;
	
	@FindBy(xpath = "//a[contains(text(),'Post')]")
	WebElement postOption;
	
	@FindBy(css = "a[class='borderCircle text-center mat-fab mat-accent']")
	WebElement sendImageVideoButton;	
	
	@FindBy(xpath = "//div[@class='sendBtn']")
	WebElement sendAudioButton;
	
	@FindBy(xpath = "//textarea[@placeholder='Add a Caption']")
	WebElement addACaption;
	
	@FindBy(css = "a[class='text-center mat-fab']")
	WebElement chatWithAdminButton;
	
	@FindBy(css = "i[class='zmdi zmdi-more-vert']")
	WebElement rightDrawer;
	
	
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
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			attachmentPinIcon.click();
		}
		else {
			log.info("Loader is still present");
		}
			}
	
	public void clickOnCameraOption() {
		log.info("Clicking on camera option");
		logExtentReport("Clicking on camera option");
		waitHelper.waitForElementVisible(cameraOption, ObjectReader.reader.getExplicitWait());
		cameraOption.click();
	}	
	
	public void clickOnImageOption() {
		log.info("Clicking on image option");
		logExtentReport("Clicking on image option");
		waitHelper.waitForElementVisible(imageOption, ObjectReader.reader.getExplicitWait());
		imageOption.click();
	}	
	
	public void clickOnVideoOption() {
		log.info("Clicking on video option");
		logExtentReport("Clicking on video option");
		waitHelper.waitForElementVisible(videoOption, ObjectReader.reader.getExplicitWait());
		videoOption.click();
	}	
	
	public void clickOnAudioOption() {
		log.info("Clicking on audio option");
		logExtentReport("Clicking on audio option");
		waitHelper.waitForElementVisible(audioOption, ObjectReader.reader.getExplicitWait());
		audioOption.click();
	}	
	
	public void clickOnRecordAudioOption() {
		log.info("Clicking on record a audio option");
		logExtentReport("Clicking on record a audio option");
		waitHelper.waitForElementVisible(recordAudioOption, ObjectReader.reader.getExplicitWait());
		recordAudioOption.click();
	}	
	
	public void clickOnChooseAudioOption() {
		log.info("Clicking on choose audio option");
		logExtentReport("Clicking on choose audio option");
		waitHelper.waitForElementVisible(chooseAudioOption, ObjectReader.reader.getExplicitWait());
		chooseAudioOption.click();
	}	
	
	public void clickOnLocationOption() {
		log.info("Clicking on location option");
		logExtentReport("Clicking on location option");
		waitHelper.waitForElementVisible(locationOption, ObjectReader.reader.getExplicitWait());
		locationOption.click();
	}	
	
	public void clickOnDocumentOption() {
		log.info("Clicking on document option");
		logExtentReport("Clicking on document option");
		waitHelper.waitForElementVisible(documentOption, ObjectReader.reader.getExplicitWait());
		documentOption.click();
	}	
	
	public void clickOnPostOption() {
		log.info("Clicking on post option");
		logExtentReport("Clicking on post option");
		waitHelper.waitForElementVisible(postOption, ObjectReader.reader.getExplicitWait());
		postOption.click();
	}	
		
	public void addCaptionForMedia(String message) throws Exception {
		log.info("Adding caption for file");
		logExtentReport("Adding caption for file");
		waitHelper.waitForElementVisible(addACaption, ObjectReader.reader.getExplicitWait());
		addACaption.sendKeys(message);
		//Thread.sleep(1000);
	}
	
	public void clickOnSendImageOrVideoButton() {
		log.info("Clicking on send button");
		logExtentReport("Clicking on send button");
		waitHelper.waitForElementVisible(sendImageVideoButton, ObjectReader.reader.getExplicitWait());
		sendImageVideoButton.click();
	}	
	
	public void clickOnSendAudioButton() {
		log.info("Clicking on send button");
		logExtentReport("Clicking on send button");
		waitHelper.waitForElementVisible(sendAudioButton, ObjectReader.reader.getExplicitWait());
		sendAudioButton.click();
	}	
}
