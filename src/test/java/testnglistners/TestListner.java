package testnglistners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//Generate Custom PDF Reports email screenshots using IReporter or ITestListner 

public class TestListner implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("I am inside listner onFinish"+" - "+arg0.getName());
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("I am inside listner onStart"+" - "+arg0.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("I am inside listner onTestStart"+" - "+arg0.getName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("I am inside listner onTestSucess"+" - "+arg0.getTestName());
		
	}
	
	

}
