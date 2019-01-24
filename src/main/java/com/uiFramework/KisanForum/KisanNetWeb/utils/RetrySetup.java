package com.uiFramework.KisanForum.KisanNetWeb.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetrySetup implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int  maxRetryCount= 3;
    
	public boolean retry(ITestResult result) {
		
		if(retryCount<maxRetryCount) {
			retryCount++;
			System.out.println("Retrying Test Method : " +result.getName() +" For " +retryCount +" Times.");
			return true;
		}
		return false;
	}

}
