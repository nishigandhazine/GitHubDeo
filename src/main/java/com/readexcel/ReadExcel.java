package com.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
public void readExcel() throws IOException {
	String excelpath="C:\\Users\\Ravindra Magar\\eclipse-workspace\\SVBProject1\\TestData\\TestData.xlsx";
	String filename="TestData";
	String sheetname ="Test";
	//create obj of file class to get the file path
	File file = new File(excelpath);
	// to read the file - FileInputStream
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet =wb.getSheet(sheetname);
	int totalrowcount = sheet.getLastRowNum();
	//total row
	System.out.println("Total rows :"+totalrowcount);
	//for particular value
	String data=sheet.getRow(0).getCell(1).getStringCellValue();
	System.out.println(data);
	//for each value
	for(int i=0; i<=totalrowcount;i++) {
		Row row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) 
		{
			String data1=sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.print(data1+" ");
		}
		System.out.println();
	}
	wb.close();
}
}
