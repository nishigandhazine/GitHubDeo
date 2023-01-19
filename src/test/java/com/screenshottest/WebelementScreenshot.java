package com.screenshottest;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;


public class WebelementScreenshot {
	WebDriver driver;
	@Test
	public void elementSnap() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement element=driver.findElement(By.xpath("//button[text()='Log in']"));
		//create a obj of ashot() class and get the image co ordinates
		//and by coordsProvider() method and take screenshot using takesscreenshot method 
		Screenshot screenshot = new AShot().
				coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
		//copy the screenshot to desired location
		try {
			ImageIO.write(screenshot.getImage(),"png",new File
("C:\\Users\\Ravindra Magar\\eclipse-workspace\\SVBProject1\\Screenshots\\element.png"));
		}catch(IOException e){
			e.printStackTrace();
			
		}
		driver.close();
	}


}
