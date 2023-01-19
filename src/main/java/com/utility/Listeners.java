package com.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.BaseClass;
import com.extentmanager.Extent_Manager;

public class Listeners extends Extent_Manager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test =extent.createTest(result.getName()+System.currentTimeMillis());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass test case is : "+result.getName()+System.currentTimeMillis());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test case failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +" - test case failed",ExtentColor.RED));
		String path = BaseClass.screenShot(BaseClass.driver, result.getName());
		try{test.addScreenCaptureFromPath(path);
		}catch(IOException e ) {
			e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is : "+result.getName()+System.currentTimeMillis());
	}}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
