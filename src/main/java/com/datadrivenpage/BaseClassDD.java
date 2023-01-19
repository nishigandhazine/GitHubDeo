package com.datadrivenpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.utility.NewExcelLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassDD {
	public static WebDriver driver;
	 NewExcelLibrary obj = new NewExcelLibrary("C:\\Users\\Ravindra Magar\\eclipse-workspace\\SVBProject1\\TestData\\Data.xlsx");
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.apps.dalalstreet.ai/login");
}
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	@DataProvider(name= "Credentials")
	public Object[][] getData() {
		Object [][]data= new Object[3][2] ;
		data[0][0]="nishigandhazine@gmail.com";
		data[0][1]="Nishi@1996";
		
		data[1][0]="nishigandhazine@gmail.com";
		data[1][1]="Nishi";
		
		data[2][0]="n@gmail.com";
		data[2][1]="Nishi@1996";
		return data;
			
		
	}
	@DataProvider(name="Credentials1")
	public Object[][] getExcelData() {
		//total row count
		int rows=obj.getRowCount("UserData");
		//total number of col
	int col=	obj.getColumnCount("UserData");
	int actrow=rows-1;
	Object[][] data = new Object[actrow][col];
	for(int i=0;i<actrow;i++) {
		for(int j=0;j<col;j++) {
			data[i][j]=obj.getCellData("UserData", j, i+2);
			
		}
	}return data;
	}
}
