	package com.orangeHRM.test_layer;

import org.testng.annotations.Test;

import com.utility.NewExcelLibrary;

public class ExcelLibraryTest {
	NewExcelLibrary obj = new NewExcelLibrary("C:\\Users\\Ravindra Magar\\eclipse-workspace\\SVBProject1\\TestData\\TestData.xlsx");
@Test(priority=1)
public void TestCase1() {
	//total row count
	int totalrows=obj.getRowCount("Employee");
	System.out.println("Total rows : "+totalrows);
}
@Test(priority = 2)
public void testCase2() {
 String salary=obj.getCellData("Employee", "Salary", 4);
 System.out.println("salary is: "+salary);
}
@Test(priority = 3)
public void testCase3() {
 String rating=obj.getCellData("Employee", 4, 2);
 System.out.println("Rating is: "+rating);
 int a=10;
 Double sum=Double.valueOf(rating)+a;  //wrapper class for converting int to double
 System.out.println("Yhe rating is now : "+sum);
}
@Test(priority = 4)
public void testCase4() {
	obj.setCellData("Employee", "ID", 2, "105");
}
@Test(priority = 5)
public void testCase5() {
	boolean b=obj.addSheet("NewEmp");
	System.out.println(b);
	boolean r=obj.removeSheet("NewEmp");
	System.out.println(r);
}



}
