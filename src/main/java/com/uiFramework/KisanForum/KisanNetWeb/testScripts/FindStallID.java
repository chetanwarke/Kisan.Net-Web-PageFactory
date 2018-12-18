package com.uiFramework.KisanForum.KisanNetWeb.testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.testbase.TestBase;

public class FindStallID extends TestBase {

	@Test(description="BookWithGSTWithPromo test with valid credentials")
	public void testBookWithGSTWithPromocode() throws Exception{
		getApplicationUrl(ObjectReader.reader.getUrl());
		WebElement username = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		WebElement login = driver.findElement(By.cssSelector("span[class='mat-button-wrapper']"));
		username.click();
		username.sendKeys("9021633629");
		System.out.println("Entered username");
		
		password.click();
		password.sendKeys("Kisanabhi@1388");
		System.out.println("Entered password");
		
		login.click();
		WebElement bookingRequest = driver.findElement(By.xpath("//span[contains(text(),'Booking Requests')]"));
		bookingRequest.click();
		System.out.println("clicked login button");
		Thread.sleep(15000);
		
		WebElement searchByName = driver.findElement(By.cssSelector("input[class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-pristine ng-valid ng-touched']"));
		searchByName.click();
		searchByName.sendKeys("9021633629");
		System.out.println("Entered mobile number");
		
		WebElement showAll = driver.findElement(By.cssSelector("div[class='mat-checkbox-inner-container']"));
		showAll.click();
		System.out.println("checked show all");
		
		/*WebElement reload = driver.findElement(By.xpath("//i[contains(text(),'refresh')]"));
		reload.click();
		System.out.println("clicked refresh");*/
		
		Thread.sleep(5000);
		
		List<WebElement> stallIds = (List<WebElement>) driver.findElements(By.cssSelector("td[class='textNormal']"));
		for(int i=0;i<stallIds.size();i++) {
			System.out.println(stallIds.get(i).getText());
		}
		
		Thread.sleep(15000);


	}
	
}
