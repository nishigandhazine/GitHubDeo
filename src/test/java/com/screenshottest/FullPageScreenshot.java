package com.screenshottest;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class FullPageScreenshot {
WebDriver driver;
@Test
public void fullPageSnap() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.automationtestinginsider.com/2020/04/how-to-find-broken-links-using-selenium.html");
	//create a obj of ashot() class and set image strategy by shootingStrategymethod
	//and viewportpasting method and take screenshot using takesScreenshot method 
	Screenshot screenshot = new AShot().
			shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
	//copy the screenshot to desired location
	try {
		ImageIO.write(screenshot.getImage(),"png",new File("C:\\Users\\Ravindra Magar\\eclipse-workspace\\SVBProject1\\Screenshots\\fullscreenshot.png"));
	}catch(IOException e){
		e.printStackTrace();
		
	}
	driver.close();
}


}
