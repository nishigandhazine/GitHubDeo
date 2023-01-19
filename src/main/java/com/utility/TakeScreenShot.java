package com.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
public static void screenshot(WebDriver driver, String filename) {
	TakesScreenshot ts =((TakesScreenshot)driver);
	File source =ts.getScreenshotAs(OutputType.FILE);
	//**** instead of string path we can we System.getProperty("user.dir")+"foldernameAndfilename.ext")
	//String path ="C:\\Users\\Ravindra Magar\\eclipse-workspace\\SVBProject1\\Screenshots\\google.png";
	File Destination = new File (System.getProperty("user.dir")+ "\\Screenshots\\"+filename+".png");
	try {
		FileUtils.copyFile(source, Destination);
		//***FileHandler.copy(source, Destination);*** we can use FileHandler.copy as well
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
