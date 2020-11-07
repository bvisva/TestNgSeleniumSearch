package testngmain;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

public class BaseTestConfiguration {
	
	@BeforeSuite(alwaysRun = true)
	  public void beforeSuite(ITestContext context) {
		  String chromdriver = context.getCurrentXmlTest().getParameter("selenium.chromedriver");
		  String chromedriverurl = context.getCurrentXmlTest().getParameter("selenium.chromedriverurl");
		  System.setProperty(chromdriver,chromedriverurl);
		  //System.setProperty("webdriver.chrome.driver",
					//"C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\chromedriver.exe");
		  System.out.println("I am in beforeSuite Method" +" - "+"beforeSuite");
	  }

}
