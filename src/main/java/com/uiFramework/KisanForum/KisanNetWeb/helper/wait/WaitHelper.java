package com.uiFramework.KisanForum.KisanNetWeb.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;

public class WaitHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.info("WaitHelper object created..");
	}

	/**
	 * This is ImplicitWait method
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	/**
	 * This will help us to get WebDriverWait object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	/**
	 * This method will make sure element is visible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	
	
	public void WaitForElementInVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		//log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.invisibilityOf(element));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loadingoverlay']")));
		log.info("element is visible now");
	}

	/**
	 * This method will make sure elementToBeClickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
	}

	/**
	 * This method will make sure invisibilityOf element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisibile now");
		return status;
	}

	/**
	 * This method will wait for frameToBeAvailableAndSwitchToIt
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched");
	}

	/**
	 * This method will give is fluentWait object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void pageLoadTime(long timeout, TimeUnit unit){
		log.info("waiting for page to load for : "+ timeout+ " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}
	
	/**
	 * This method will make sure elementToBeVisible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	
	/**
	 * This method will make sure elementToBeVisible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	
	public void waitForAllElementVisible(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		log.info("element is visible now");
	}

	/**
	 * This method will make sure all elements are present
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForAllElement(By element, int timeOutInSeconds) {
		log.info("waiting for :" + driver.findElement(element).toString() +"s" + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		log.info("elements are visible now");
	}
	
	/**
	 * This method will wait for loader to disappear
	 * @return 
	 * @throws Exception 
	 * 
	 */
	/*public void waitForElementEnabled(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + "to be enabled for" + timeOutInSeconds + "seconds");
		if(!element.isEnabled()) {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.);
		}
	}*/
	
	
	/**
	 * This method will wait for loader to disappear
	 * @return 
	 * @throws Exception 
	 * 
	 */
	public Boolean WaitForElementDisapper(WebElement element)
    {
        try
        {
            while (true)
            {
                if (element.isDisplayed()) {
                        Thread.sleep(2000);
                }
                else
                {
                    break;
                }
            }
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
		
	
	public void waitForStalenessOfElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.stalenessOf(element));
		log.info("element is visible now");
	}
	
	/**
	 * this method will wait for page to be loaded by using javascript
	 */
	
	public void javaScriptWait(int timeOutInSeconds) {
		ExpectedCondition<Boolean> javaScriptWait = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver input) {	
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		
		try {
			System.out.println("Waiting for page to load");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(javaScriptWait);
		} catch(Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after" + 20 + "seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete");
		}
	}
}
