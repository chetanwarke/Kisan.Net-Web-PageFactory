package com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config;

import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();
	public String getProductAndServices();
	public String getGSTNumber();
	public String getRegisteredGSTAddress();
	public String getPincode();
	public String getCountry();
	public String getstate();
	public String getCity();
	public String getCompanyname();
	public String getLastname();
	public String getFirstname();
	public String getPromocode();
}
