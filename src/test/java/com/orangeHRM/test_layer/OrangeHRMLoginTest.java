package com.orangeHRM.test_layer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.extentmanager.Extent_Manager;

public class OrangeHRMLoginTest extends BaseClass {
	@Test
public void orangeHRMLogo() {
		 
	WebElement image=driver.findElement(By.xpath("(// img[@style='margin-right:10px'])[1]"));
	Assert.assertTrue(image.isDisplayed());
	
}
	@Test
	public void loginPageTest() {
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("nishigandhazine@gmail.com");
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("Nishi@96");
		driver.findElement(By.xpath("")).sendKeys("//button[text()='Log in']");
		
	}
	@Test
public void loginTest() {
		
	driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
	driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	
	String actual_URL = driver.getCurrentUrl();
	String expected_URL="https://demoblaze.com/cart.html";
	Assert.assertEquals(actual_URL, expected_URL);
}
	@Test
	public void sampleCase() {
		Extent_Manager.test.createNode("Validation 1");
		Assert.assertTrue(true);
		Extent_Manager.test.createNode("Validation 2");
		Assert.assertTrue(true);
		Extent_Manager.test.createNode("Validation 3");
		Assert.assertTrue(true);
		Extent_Manager.test.createNode("Validation 4");
		Assert.assertTrue(true);
	}
}
