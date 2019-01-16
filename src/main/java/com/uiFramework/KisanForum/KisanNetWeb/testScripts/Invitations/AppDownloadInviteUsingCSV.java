package com.uiFramework.KisanForum.KisanNetWeb.testScripts.Invitations;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.AssertionHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.fileUpload.fileUploadHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.HomePage;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.InvitePage;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LoginPage;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;



public class AppDownloadInviteUsingCSV extends TestBase{

private final Logger log = LoggerHelper.getLogger(AppDownloadInviteUsingCSV.class);
public fileUploadHelper fileUpload = new fileUploadHelper();
	
	@Test(dataProvider = "getInviteList",description = "Invite to download app with CSV")
	public void inviteManuallyToValidNumber(String emailId, String password, String mobileNumber, String runMode) throws Exception {
		if(runMode.equalsIgnoreCase("n")) {
			throw new SkipException("Run mode for this data is marked N");
		}
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(emailId, password);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnRightOptionMenu();
		homePage.clickOnInviteToAppButton();
		
		InvitePage invitePage = new InvitePage(driver);
		invitePage.clickOnUploadCSVFile();
		
		fileUpload.CopyFilePath("sampleCSVfileForAppDownload.csv");
		fileUpload.PasteFilePath();
		fileUpload.ClickEnter();
		
		invitePage.clickOnSendCSVInviteButton();
		
		boolean status = invitePage.verifyInviteSuccessToast();
		AssertionHelper.updateTestStatus(status);
	}
	

	@DataProvider(name = "getInviteList")
	public Object[][] getInviteList() throws Exception {
		Object[][] data = getExcelData("Kisan.NetTestData.xlsx", "Invite To Download App");
		return data;
	}
	
}
