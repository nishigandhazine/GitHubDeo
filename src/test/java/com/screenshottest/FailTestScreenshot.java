package com.screenshottest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utility.TakeScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FailTestScreenshot {
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
		Assert.assertTrue(false);
		}
	@Test
	public void testCase2() {
		Assert.assertTrue(true, "test passed");
		}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.FAILURE==result.getStatus())
		{
			TakeScreenShot.screenshot(driver, result.getName()+"_"+ System.currentTimeMillis());
		}
		driver.close();
		}}
