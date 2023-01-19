package com.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableBaseClass {
@Test
public void setUp() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.guru99.com/test/web-table-element.php#");
	List<WebElement> tablerow = driver.findElements(By.xpath("//table//thead/tr/th"));
	//System.out.println(tablerow.size());
	int count = tablerow.size();
	System.out.println(count);
	for(int i=0;i<count;i++) {
		String a=tablerow.get(i).getText();
		System.out.println(a);
	}


}
}
