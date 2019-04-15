package com.uiFramework.KisanForum.KisanNetWeb.testScripts.Messaging;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.helper.fileUpload.FileUploadHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.ChannelChatWindow;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.HomePage;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LeftDrawer;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LoginPage;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class SendOneToOneImageToFollower extends TestBase{

	public final Logger log = LoggerHelper.getLogger(SendTextMessageToAdmin.class);
	public FileUploadHelper fileUpload = new FileUploadHelper();

	
	@Test(dataProvider = "Send one to one image to follower")
	public void sendOneToOneImageToFollower(String emailId, String password, String channelName, String message, String runMode) throws Exception {
		if(runMode.equalsIgnoreCase("n")) {
			throw new SkipException("Run mode for this data is marked N");
		}
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(emailId, password);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLeftDrawerIcon();
		
		LeftDrawer leftDrawer = new LeftDrawer(driver);
		leftDrawer.clickOnMyChannelOption();
		
		ChannelChatWindow channelChatWindow = new ChannelChatWindow(driver);
		channelChatWindow.clickOnFirstFollowerFromOneToOneChatList();
		channelChatWindow.clickOnAttachmentPin();
		channelChatWindow.clickOnImageOption();
			
		fileUpload.CopyFilePath("Image For Followers.jpg");
		fileUpload.PasteFilePath();
		fileUpload.ClickEnter();
		
		channelChatWindow.addCaptionForMedia(message);
		channelChatWindow.clickOnSendImageOrVideoButton();
		Thread.sleep(5000);
	}
	
	@DataProvider(name = "Send one to one image to follower")
	public Object[][] getMessageForFollower() throws Exception{
		Object[][] dataSet = getExcelData("Kisan.NetTestData.xlsx", "SendMessageOneToOne");
		return dataSet;
	}
}
