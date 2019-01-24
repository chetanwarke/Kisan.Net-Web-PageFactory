package com.uiFramework.KisanForum.KisanNetWeb.testScripts.FollowAndUnFollowChannel;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.HomePage;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LeftDrawer;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LoginPage;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class UnfollowChannelFromUserProfile extends TestBase{

	private final Logger log = LoggerHelper.getLogger(UnfollowChannelFromUserProfile.class);
	
	@Test(dataProvider = "Channel To Be Unfollowed")
	public void unfollowChannelFromUserProfile(String emailId, String password, String channelName, String runMode) throws Exception {
		
		if(runMode.equalsIgnoreCase("n")) {
			throw new SkipException("Run mode for this data is marked N");
		}
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(emailId, password);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLeftDrawerIcon();
		
		LeftDrawer leftDrawer = new LeftDrawer(driver);
		leftDrawer.clickOnUserProfileImage();
		
	}
	
	
	@DataProvider(name = "Channel To Be Unfollowed")
	public Object[][] getChannelList() throws Exception{
		Object[][] data = getExcelData("Kisan.NetTestData.xlsx", "Follow Channels");
		return data;
	}
}
