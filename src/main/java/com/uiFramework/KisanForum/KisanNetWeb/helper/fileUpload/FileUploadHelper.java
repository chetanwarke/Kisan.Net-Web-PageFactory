package com.uiFramework.KisanForum.KisanNetWeb.helper.fileUpload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.KisanForum.KisanNetWeb.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.resource.ResourceHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.wait.WaitHelper;

public class FileUploadHelper {
	
	private static Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	static Robot robot;
	WebDriver driver;
	WaitHelper waitHelper;

	public FileUploadHelper(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public String getFilePath(String fileName) throws Exception{
		String fileLocation = ResourceHelper.getResourcePath("src/main/resources/configfile/")+fileName;
		log.info("filel location "+fileLocation);
		return fileLocation;
	}
	
	public void CopyFilePath(String fileName) {
		try {
			robot = new Robot();

			robot.setAutoDelay(2000);
			/*FileUploadHelper getFilePath = new FileUploadHelper();
			String path = getFilePath.getFilePath(fileName);*/
			
			String path = ResourceHelper.getResourcePath("src\\main\\resources\\testData\\")+fileName;
			log.info("File Location "+path);
			
			StringSelection filepath = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			robot.setAutoDelay(2000);
		} catch (Exception e) {

		}
	}

	public void PasteFilePath() {

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
	
	}

	public void ClickEnter() {
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void uploadFile(WebElement waitElement, WebElement media, String fileName) {
		String filepath = ResourceHelper.getResourcePath("src\\main\\resources\\testData\\")+fileName;
		log.info("File Location "+filepath);
		waitHelper.waitForElementVisible(waitElement, ObjectReader.reader.getExplicitWait());
		media.sendKeys(filepath);
	}
	
}
