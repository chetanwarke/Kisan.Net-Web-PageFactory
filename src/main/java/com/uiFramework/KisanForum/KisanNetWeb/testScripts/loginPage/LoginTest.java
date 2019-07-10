package com.uiFramework.KisanForum.KisanNetWeb.testScripts.loginPage;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LoginPage;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class LoginTest extends TestBase{
	@Test(dataProvider="testData",description="Login to App")
	public void loginToApp(String emailId, String password, String runMode) throws Exception {
		if(runMode.equalsIgnoreCase("n")) {
			throw new SkipException("Run mode for this data is marked N");
		}
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(emailId, password);
		/*HomePage homePage = new HomePage(driver);
		Thread.sleep(15000);
		homePage.clickOnRightOptionMenu();
		homePage.clickOnSearchButton();
		homePage.enterChannelNameInSearchBox("KISAN");
		homePage.clickOnChannelName("KISAN");*/
		Thread.sleep(5000);
		// Commenting below code as login method is written in login page
		
		/*loginPage.switchToFacebookFrame();
		loginPage.clickOnCloseButton();
		loginPage.clickOnExhibitorLoginButton();
		loginPage.enterEmailId(emailId);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();*/
	}
	
	@DataProvider(name="testData")
	public Object[][] testData() throws Exception{
		Object[][] data = getExcelData("Kisan.NetTestData.xlsx", "LoginData");
		return data;
	}	
	
}
