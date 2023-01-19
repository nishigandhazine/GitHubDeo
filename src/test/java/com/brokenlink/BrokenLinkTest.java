package com.brokenlink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkTest {

	 WebDriver driver;
	 List<WebElement> activeLinkImage = new ArrayList<WebElement>();
@BeforeTest
public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://css-tricks.com/thispagedoesntexist");
	
} @Test(priority = 1)
public void getLinks() {

	  // List of all links and images
	  List<WebElement> linkImgList = driver.findElements(By.tagName("a"));
	  linkImgList.addAll(driver.findElements(By.tagName("img")));

	  // Total Links and Images Before
	  int total = linkImgList.size();
	  System.out.println("Total Links and Images are: " + total);

	  for (int i = 0; i < linkImgList.size(); i++) {
	   if (linkImgList.get(i).getAttribute("href") != null &&(!linkImgList.get(i).getAttribute("href").contains("javascript"))) {
	    activeLinkImage.add(linkImgList.get(i));
	   }
	  }
	  // Total Links and Images After
	  int total1 = activeLinkImage.size();
	  System.out.println("Total Active Links and Images: " + total1);
	 }
	 @Test(priority = 2)
	 public void VerifyBrokenLinks() throws IOException {
	  VerifyBrokenLinks obj= new VerifyBrokenLinks();
	  for(int j=0;j<activeLinkImage.size();j++)
	  {
	   WebElement ele= activeLinkImage.get(j);
	   String url=ele.getAttribute("href");
	   obj.verifyBrokenLinks(url);
	  }
	  System.err.println("Total Valid Links: "+obj.validLink);
	  System.err.println("Total Invalid Links: "+obj.invalidLink);
	 }
	 @AfterTest
	 public void tearDown() {
	  driver.close();
	 }

}
