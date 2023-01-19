package com.screenshottest;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.TakeScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTest {
	WebDriver driver;
	@BeforeMethod
public void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
}
	@Test
	public void testCase1() {
		driver.findElement(By.name("q")).sendKeys("screenshot demo");
		TakeScreenShot.screenshot(driver,"googlesnap");
		}
	@Test
	public void testCase2() {
		
		TakeScreenShot.screenshot(driver,"googlespage");
		}
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
}
