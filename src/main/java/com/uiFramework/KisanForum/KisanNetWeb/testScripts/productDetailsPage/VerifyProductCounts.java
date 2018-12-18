package com.uiFramework.KisanForum.KisanNetWeb.testScripts.productDetailsPage;

import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.AssertionHelper;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.ApplicationText;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.LoginPageBhanu;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.NavigationMenu;
import com.uiFramework.KisanForum.KisanNetWeb.pageObject.ProductCategoryPage;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;



public class VerifyProductCounts extends TestBase{
	
	LoginPageBhanu loginPage;
	NavigationMenu navigationMenu;
	
	@Test
	public void testVerifyProductCounts(){
		
		navigationMenu = new NavigationMenu(driver);
		ProductCategoryPage pCate = navigationMenu.clickOnMenu(navigationMenu.womenMenu);
		
		pCate.selectColor(ApplicationText.Orange);
		int count = pCate.getTotalProducts();
		
		if(count==3){
			AssertionHelper.markPass();
		}
		else{
			AssertionHelper.markFail("product count is not matching");
		}
	}
}
