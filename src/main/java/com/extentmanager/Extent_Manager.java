package com.extentmanager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Manager {
	public static ExtentHtmlReporter htmlreporter;
	public  static ExtentReports extent;
	public static ExtentTest test;
	public static void setExtent() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport.html");
		htmlreporter.config().setDocumentTitle("Automation Test Report");
		htmlreporter.config().setReportName("Orange HRM Test Automation report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "MyHost");
		extent.setSystemInfo("ProjectName", "OrangeHrm");
		extent.setSystemInfo("Tester", "Nishi");
		extent.setSystemInfo("OS", "Window");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
}
