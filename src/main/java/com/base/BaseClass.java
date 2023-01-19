package com.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.extentmanager.Extent_Manager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
//public static Logger logger;
public ExtentHtmlReporter htmlreporter;
public ExtentReports extent;
public ExtentTest test;
public Properties prop;
@BeforeSuite
public void beforeSuite() {
	Extent_Manager.setExtent();
}

@AfterSuite
public void afterSuite() {
	Extent_Manager.endReport();
}
/*
@BeforeClass
public void start() {
	logger=Logger.getLogger("My automation framework");
	PropertyConfigurator.configure("Log4jCode.properties");
	logger.info("Framework execution started");
}
@AfterClass
public void end() {
	logger.info("Framework execution stopped");
}
*/
@BeforeMethod
public void setup() {
	readConfig();
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	//driver.get("https://demoblaze.com/");// for extent report
	//logger.info("Browser launches, url hit, maximized....");
}

@AfterMethod
public void tearDown() {
	
	driver.close();
}
public void readConfig() {
	try {
		prop = new Properties();
		FileInputStream fs = new  FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		prop.load(fs);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
public static String screenShot(WebDriver driver, String filename) {
	String dateName = new SimpleDateFormat("YYYYMMDD").format(new Date());
	TakesScreenshot ts = ((TakesScreenshot)driver);
	File source = ts.getScreenshotAs(OutputType.FILE);
	File Destination = new File(System.getProperty("user.dir")+"\\Screenshots\\"+filename+"_"+dateName+".png");
	try {
		FileUtils.copyFile(source, Destination);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return filename;
	
}


	

}
