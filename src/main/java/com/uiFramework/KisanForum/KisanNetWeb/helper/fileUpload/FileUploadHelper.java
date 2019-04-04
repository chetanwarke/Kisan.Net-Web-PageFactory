package com.uiFramework.KisanForum.KisanNetWeb.helper.fileUpload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;

import com.uiFramework.KisanForum.KisanNetWeb.helper.assertion.AssertionHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.excel.ExcelHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.resource.ResourceHelper;

public class FileUploadHelper {

	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	static Robot robot;


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
			
			String path = ResourceHelper.getResourcePath("src\\main\\resources\\configfile\\")+fileName;
			log.info("csv location "+path);
			
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

}
