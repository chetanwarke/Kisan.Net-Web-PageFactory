package com.uiFramework.KisanForum.KisanNetWeb.testScripts;

import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.AssertionHelper;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class Test2 extends TestBase{

	
	@Test
	public void testLogin(){
		AssertionHelper.markPass();
	}
	
	@Test
	public void testLogin1(){
		AssertionHelper.markFail();
	}
	
	@Test
	public void testLogin2(){
		AssertionHelper.markPass();
	}
	
	@Test
	public void testLogin3(){
		AssertionHelper.markFail();
	}
}
