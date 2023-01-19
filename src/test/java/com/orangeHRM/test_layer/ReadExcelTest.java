package com.orangeHRM.test_layer;

import org.testng.annotations.Test;

import com.readexcel.Excel_Library;

public class ReadExcelTest {
	@Test
	public void readExcelTest() throws Exception {
		Excel_Library obj = new Excel_Library();
		String particulardata=obj.readData("test", 5, 1);
		System.out.println("The data is : "+particulardata);
	}

}
