package com.handledatepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerByJavaScript {
	WebDriver driver;
@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=10.0_1");
		
		
		}
@Test
public void datePickerByJS() throws InterruptedException {
	WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
	
String datestrings ="04/26/1996";
datePickerByJs(driver,datestrings,element);
}

public void datePickerByJs(WebDriver driver, String date,WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value',"+date+")", element);
}
}
