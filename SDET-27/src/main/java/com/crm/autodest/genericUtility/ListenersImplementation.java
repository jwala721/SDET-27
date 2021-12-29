package com.crm.autodest.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// capture the method name
		String methodName = result.getMethod().getMethodName();
		
		//capture the current date
		String currentDate = new JavaUtility().getSystemDateWithFormate();
		//concatenate for screenshot name
		String screenShotName = methodName+"_"+currentDate;
		
		try {
			new WebDriverUtility().takeScreenshot(BaseClass.sdriver, screenShotName);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

	private Object JavaUtility() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

	
	

}
