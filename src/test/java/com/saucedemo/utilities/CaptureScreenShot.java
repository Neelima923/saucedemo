package com.saucedemo.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenShot {
	public void TakeSnapShot(WebDriver driver) throws IOException
	{File sourcescreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationscreenshot=new File("./screenshots/image1.png");
	FileUtils.copyFile(sourcescreenshot,destinationscreenshot);
		//byte[] screenshotinbytes= ((TakeScreenshot)driver).getScreenshotAs(OutputType.BYTES);

	}
}

