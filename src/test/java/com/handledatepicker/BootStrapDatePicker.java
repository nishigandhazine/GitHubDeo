package com.handledatepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDatePicker {
	WebDriver driver;
@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=10.0_1");
		}
@Test
	public void datePicker() {
		String month ="September 2022";
		String day = "22";
		driver.findElement(By.xpath("//input[@class='form-control']")).click();
		while(true) {
			String text =driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText();
		if(text.equals(month)) {
			break;
		}else {
			driver.findElement(By.xpath("(//th[@class='prev'])[1]")).click();
			// for forword button
				//driver.findElement(By.xpath("(//th[@class='next'])[1]")).click();
		}
		}
		driver.findElement(By.xpath("//td[contains(text(),"+day+")]")).click();
	}
	
}
