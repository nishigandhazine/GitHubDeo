package com.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Library {
XSSFWorkbook wb;
XSSFSheet sheet;
public Excel_Library() throws Exception{
	String excelpath="C:\\Users\\Ravindra Magar\\eclipse-workspace\\SVBProject1\\TestData\\TestData.xlsx";
	File file = new File(excelpath);
	FileInputStream fis = new FileInputStream(file);
	wb = new XSSFWorkbook(fis);
}
public String readData(String sheetname,int row,int col) {
	sheet=wb.getSheet(sheetname);
	String data=sheet.getRow(row).getCell(col).getStringCellValue();
	return data;
}
}
