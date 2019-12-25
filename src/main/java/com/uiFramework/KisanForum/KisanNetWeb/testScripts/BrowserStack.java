package com.uiFramework.KisanForum.KisanNetWeb.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack {

	public static final String USERNAME = "abhijeet106";
	  public static final String AUTOMATE_KEY = "YnxebgxpS2ZuD4uUeL3y";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  public static void main(String[] args) throws Exception {

	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("browser", "Firefox");
	    caps.setCapability("browser_version", "71.0 beta");
	    caps.setCapability("resolution", "1920x1080");
	    caps.setCapability("browserstack.local", "false");
	    caps.setCapability("browserstack.selenium_version", "3.5.2");


	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.get("https://id.kisanlab.com/accounts/org/login/?client_id=3a037a6d-be9a-43f8-8a30-6918fc93ad9e&client_secret=68eeec35-275e-42ed-8b4c-f062d53e3877&return_url=https://net.kisanlab.com/");
	    
	 
	    Thread.sleep(3000);
	    WebElement emailId = driver.findElement(By.id("username"));
	    emailId.click();   
	    emailId.clear();
	    emailId.sendKeys("extra2@mailinator.com");
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("kisankisan");
	    
	    WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));    
	    loginButton.click();

	    System.out.println(driver.getTitle());
	    driver.quit();

	  }
	
}
