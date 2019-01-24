package com.uiFramework.KisanForum.KisanNetWeb.testScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test {
	@BeforeSuite
	public void beforesuit() {
		System.out.println("in before suite");
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("in before test");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("in before class");
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("in before method");
	}
	
	@Test(dataProvider = "test")
  public void f(int a, String b) {
		System.out.println("in at test");
  }

	@AfterSuite
	public void Aftersuit() {
		System.out.println("in after suite");
	}
	
	@AfterTest
	public void Aftertest() {
		System.out.println("in after test");
	}
	
	@AfterClass
	public void Afterclass() {
		System.out.println("in after class");
	}
	
	@AfterMethod
	public void Aftermethod() {
		System.out.println("in after method");
	}
	
	
  @DataProvider(name = "test")
  public Object[][] dp() {
    System.out.println("in data provider");
	  return new Object[][] {
        new Object[] { 1, "a" }
    };
  }
}
