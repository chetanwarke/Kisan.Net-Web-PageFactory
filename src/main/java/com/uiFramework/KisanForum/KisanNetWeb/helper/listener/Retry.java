package com.uiFramework.KisanForum.KisanNetWeb.helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;

public class Retry implements IRetryAnalyzer{
	private int retryCount = 0;
	private int maxRetryCount = 3;
	
	private Logger log = LoggerHelper.getLogger(Retry.class);

	public boolean retry(ITestResult arg0) {
		if(retryCount < maxRetryCount){
			try {
				Thread.sleep(3000);
				log.info("Retrying test "+arg0.getName()+" with status "+getResultStatusName(arg0.getStatus())+" for the " +(retryCount+1)+" times." );
				retryCount++;
				return true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public String getResultStatusName(int status){
		String resultName = null;
		if(status == 1){
			resultName = "SUCCESS";
		}
		if(status == 2){
			resultName = "FAILURE";
		}
		if(status == 3){
			resultName = "SKIP";
		}
		return resultName;
	}

}
