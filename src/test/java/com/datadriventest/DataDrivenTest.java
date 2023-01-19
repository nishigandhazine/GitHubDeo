package com.datadriventest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.datadrivenpage.BaseClassDD;

public class DataDrivenTest extends BaseClassDD{
	@Test(dataProvider="Credentials1")
	public void loginTest(String username,String password) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/div[2]/div/form/div[1]/input")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]")).click();
		Thread.sleep(2000);
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.apps.dalalstreet.ai/dashboard";
	Assert.assertEquals(actualUrl, expectedUrl);
	}

}
