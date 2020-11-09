package testngmain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase {

	private WebDriver driver;
	

	public void setDriver(WebDriver driver) {

		// driver = new ChromeDriver();
		this.driver = driver;
	}

	public WebDriver getDriver() {

		return driver;
	}	

	public abstract void configureDriver();
	
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
