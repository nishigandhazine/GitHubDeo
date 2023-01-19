package com.test.pack;

import org.testng.annotations.Test;

import com.utility.Log;

public class LogTest {
	@Test
	public void testCase1() {
		Log.startTestCase("TestCase 1 start");
		Log.info("This is test case 1");
		Log.endTestCase("Test case 1 ends");
	}
	@Test
	public void testCase2() {
		Log.startTestCase("TestCase 2 start");
		Log.info("This is test case 2");
		Log.endTestCase("Test case 2 ends");
	}
	@Test
	public void testCase3() {
		Log.startTestCase("TestCase 3 start");
		Log.info("This is test case 3");
		Log.endTestCase("Test case 3 ends");
	}

}
