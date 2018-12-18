package com.uiFramework.KisanForum.KisanNetWeb.testScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.AssertionHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LoginPage;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LoginPageBhanu;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	/*@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPageBhanu loginPage = new LoginPageBhanu(driver);
		
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		
		boolean status = loginPage.verifySuccessLoginMsg();
		
		AssertionHelper.updateTestStatus(status);
	}*/
	
	@Test(description="Onsite Registraion")
	public void loginToApp() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.switchToFacebookFrame();
		loginPage.clickOnCloseButton();
		
	}
	
}
