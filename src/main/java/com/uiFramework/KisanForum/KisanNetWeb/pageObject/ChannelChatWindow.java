package com.uiFramework.KisanForum.KisanNetWeb.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.VerificationHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.fileUpload.FileUploadHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.resource.ResourceHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;


public class ChannelChatWindow {

	WebDriver driver;
	WaitHelper waitHelper;
	VerificationHelper verificationHelper;
	FileUploadHelper fileUploadHelper;
	private final Logger log = LoggerHelper.getLogger(ChannelChatWindow.class);
	
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
	
	@FindBy(xpath = "//span[contains(text(),' Select a Location')]")
	WebElement selectLocationHeader;
	
	@FindBy(xpath = "//h2[contains(text(),'Around You')]/preceding-sibling::div")
	WebElement currentLocation;
	
	/*@FindBy(xpath = "//span[contains(text(),'Send to')]/following-sibling::a/child::i")
	WebElement sendLocationButton;*/
	
	@FindBy(xpath = "//a/child::i[@class='zmdi zmdi-mail-send']")
	WebElement sendLocationButton1;
	
	@FindBy(xpath = "//div[@class='locationPopup locationSmall']/child::mat-dialog-actions[2]/child::div/child::div/child::a/child::i")
	WebElement sendLocationButton;
	
	@FindBy(xpath = "//div[@class='gm-style']/child::iframe")
	WebElement sendLocationiFrame;
	
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
	
	@FindBy(xpath = "//input[@formcontrolname='title']")
	WebElement titleOfPost;
	
	@FindBy(xpath = "//textarea[@formcontrolname='message']")
	WebElement descriptionOfPost;
	
	@FindBy(xpath = "//input[@formcontrolname='mediaFile']")
	WebElement attachPostMedia;
	
	@FindBy(xpath = "//button[contains(text(),'Crop')]")
	WebElement cropPostImageButton;
	
	@FindBy(xpath = "//span[normalize-space(text())='POST']")
	WebElement sendPostButton;
	
	@FindBy(css = "a[class='text-center mat-fab']")
	WebElement chatWithAdminButton;
	
	@FindBy(css = "i[class='zmdi zmdi-more-vert']")
	WebElement rightDrawer;
	
	@FindAll(@FindBy(xpath = "//h3"))
	List<WebElement> oneToOneChatList;
	
	@FindBy(xpath = "//div[contains(text(),' You can not send and receive messages to this user')]")
	WebElement blockedFollowerText;
	
	@FindBy(xpath = "//span[contains(text(),'Broadcast')]")
	WebElement broadcastText;
	
	@FindBy(xpath = "//input[@accept='image/*']")
	WebElement sendImageInput;
	
	@FindBy(xpath = "//input[@accept='*']")
	WebElement sendVideoInput;
	
	@FindBy(xpath = "//input[@accept='audio/*']")
	WebElement sendAudioInput;
	
	@FindBy(xpath = "//input[@accept='.pdf, .doc, .docx']")
	WebElement sendDocumentInput;
	
	@FindBy(xpath = "//input[@accept='image/*, video/*']")
	WebElement sendPostInput;
	
	public static By allOneToOneChats = By.xpath("//h3");
	
	
	public ChannelChatWindow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		verificationHelper = new VerificationHelper(driver);
		fileUploadHelper = new FileUploadHelper(driver);
		//javascriptHelper = new JavaScriptHelper(driver);  // Removing it as it is giving stale element reference
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
	
	public void clickOnAudioOption() throws Exception {
		log.info("Clicking on audio option");
		logExtentReport("Clicking on audio option");
		waitHelper.waitForElementVisible(audioOption, ObjectReader.reader.getExplicitWait());
		//audioOption.click();
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			audioOption.click();
		}
		else {
			log.info("Attachment options are still loading");
		}
		Thread.sleep(1000);
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
	
	public void clickOnSelectLocationHeader() {
		log.info("Clicking on select location header");
		logExtentReport("Clicking on select location header");
		waitHelper.waitForElementVisible(selectLocationHeader, ObjectReader.reader.getExplicitWait());
		selectLocationHeader.click();
	}	
	
	public void clickOnCurrentLocation() throws Exception {
		Thread.sleep(2000);
		log.info("Clicking on current location");
		logExtentReport("Clicking on current location");
		waitHelper.waitForElementVisible(currentLocation, ObjectReader.reader.getExplicitWait());
		currentLocation.click();
	}
	
	public void clickOnSendLocationButton() throws Exception {
		Thread.sleep(2000);
		log.info("Clicking on send location button");
		logExtentReport("Clicking on send location button");
		waitHelper.waitForElementVisible(sendLocationButton, ObjectReader.reader.getExplicitWait());
		sendLocationButton.click();
	}
	
	public void switchToLocationFrame() {
		log.info("Switching to iframe of location");
		logExtentReport("Switching to iframe of location");
		waitHelper.waitForframeToBeAvailableAndSwitchToIt(sendLocationiFrame, ObjectReader.reader.getExplicitWait());
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

	public void enterPostTitle(String message) throws Exception {
		log.info("Entering title of post");
		logExtentReport("Entering title of post");
		waitHelper.waitForElementVisible(titleOfPost, ObjectReader.reader.getExplicitWait());
		titleOfPost.sendKeys("Title :" + message);
		Thread.sleep(1000);
	}
	
	public void enterPostDescription(String message) throws Exception {
		log.info("Entering description of post");
		logExtentReport("Entering description of post");
		waitHelper.waitForElementVisible(titleOfPost, ObjectReader.reader.getExplicitWait());
		descriptionOfPost.sendKeys("Description of post : " + message);
		Thread.sleep(1000);
	}
	
	public void clickOnAttachPostMediaButton() {
		log.info("Clicking on attach post media button");
		logExtentReport("Clicking on attach post media button");
		//waitHelper.waitForElementVisible(attachPostMedia, ObjectReader.reader.getExplicitWait());
		attachPostMedia.click();
	}	
	
	public void clickOnCropPostMediaButton() {
		log.info("Clicking on crop button of post media");
		logExtentReport("Clicking on crop button of post media");
		waitHelper.waitForElementVisible(cropPostImageButton, ObjectReader.reader.getExplicitWait());
		cropPostImageButton.click();
	}	
	
	public void clickOnSendPostButton() throws Exception {
		log.info("Clicking on send post button");
		logExtentReport("Clicking on send post button");
		//JavaScriptHelper javascriptHelper = new JavaScriptHelper(driver);
		//javascriptHelper.scrollDownVertically();
		//javascriptHelper.scrollIntoView(false);
		Thread.sleep(1000);
		sendPostButton.click();
	}
	
	public void addCaptionForMedia(String message) throws Exception {
		log.info("Adding caption for file");
		logExtentReport("Adding caption for file");
		waitHelper.waitForElementVisible(addACaption, ObjectReader.reader.getExplicitWait());
		addACaption.sendKeys(message);		
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
	
	public List<WebElement> getOneToOneChatList(){
		log.info("Waiting for one to one chats to appear");
		logExtentReport("Waiting for one to one chats to appear");
		waitHelper.waitForAllElement(allOneToOneChats, 15);
		return oneToOneChatList;
	}
	
	public void clickOnFirstFollowerFromOneToOneChatList() {
		log.info("Clicking on first follower from one to one chat list");
		logExtentReport("Clicking on first follower from one to one chat list");
		List<WebElement> oneToOneChatList = getOneToOneChatList();		
		if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
			oneToOneChatList.get(0).click();
		}
		else {
			log.info("Follower list is still loading");
		}
		
		/*This code will check if first follower in one to one chat is blocked or removed*/
		
		int i = 1;
		while(verificationHelper.isDisplayed(blockedFollowerText)) {
			if(!waitHelper.WaitForElementDisapper(loadingOverlay)){
				oneToOneChatList.get(i).click();
				i = i + 1;
			}
			else {
				log.info("Follower list is still loading");
			}			
		}
		
	}
	
	public void clickOnBroadcastTextInHeader() throws InterruptedException {
		Thread.sleep(2000);		// added to pause execution to avoid ui disturbance
		log.info("Clicking on broadcast text in header");
		logExtentReport("Clicking on broadcast text in header");
		waitHelper.waitForElementVisible(broadcastText, ObjectReader.reader.getExplicitWait());
		broadcastText.click();
	}
	
	public void uploadImage(String fileName) throws InterruptedException {
		log.info("Uploading image");
		logExtentReport("Uploading image");
		fileUploadHelper.uploadFile(imageOption, sendImageInput, fileName);
	}
	
	public void uploadVideo(String fileName) throws InterruptedException {
		log.info("Uploading video");
		logExtentReport("Uploading video");
		fileUploadHelper.uploadFile(videoOption, sendVideoInput, fileName);
	}
	
	public void uploadAudio(String fileName) throws InterruptedException {
		log.info("Uploading audio");
		logExtentReport("Uploading audio");
		fileUploadHelper.uploadFile(chooseAudioOption, sendAudioInput, fileName);
	}
	
	public void uploadDocument(String fileName) throws InterruptedException {
		log.info("Uploading document");
		logExtentReport("Uploading document");
		fileUploadHelper.uploadFile(documentOption, sendDocumentInput, fileName);
	}
	
	public void uploadPostMedia(String fileName) throws InterruptedException {
		log.info("Uploading post");
		logExtentReport("Uploading post");
		fileUploadHelper.uploadFile(descriptionOfPost, sendPostInput, fileName);
	}
}
