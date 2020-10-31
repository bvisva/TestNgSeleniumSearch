package testngmain;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestDemo {
	
	
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  
	  System.out.println("I am in dataprovider parameter Method" +" - "+"f");
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I am in beforeMethod Method" +" - "+"beforeMethod"); 
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("I am in afterMethod Method" +" - "+"afterMethod"); 
  }


  //@factory annotaiton can be used to dynamically runtime run test classes with or without arguments passed by returning object array
  // class may need to be registered in xml test suite file
  //@factory cna be combined with @dataprovider in class constructor can be used
  //to run the same test class test methods with different set of values 
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("I am in beforeClass Method" +" - "+"beforeClass"); 
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("I am in afterClass Method" +" - "+"afterClass");
  }

  @BeforeTest
  public void beforeTest() {	  
	  
	  System.out.println("I am in beforeTest Method" +" - "+"beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("I am in afterTest Method" +" - "+"afterTest");
  }

  @BeforeSuite(alwaysRun = true)
  public void beforeSuite(ITestContext context) {
	  String chromdriver = context.getCurrentXmlTest().getParameter("selenium.chromedriver");
	  String chromedriverurl = context.getCurrentXmlTest().getParameter("selenium.chromedriverurl");
	  System.setProperty(chromdriver,chromedriverurl);
	  //System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\chromedriver.exe");
	  System.out.println("I am in beforeSuite Method" +" - "+"beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("I am in afterSuite Method" +" - "+"afterSuite");
  }
  
  /* public class DotTestListener extends TestListenerAdapter {
  private int m_count = 0;
 
  @Override
  public void onTestFailure(ITestResult tr) {
    log("F");
  }
 
  @Override
  public void onTestSkipped(ITestResult tr) {
    log("S");
  }
 
  @Override
  public void onTestSuccess(ITestResult tr) {
    log(".");
  }
 
  private void log(String string) {
    System.out.print(string);
    if (++m_count % 40 == 0) {
      System.out.println("");
    }
  }
}
  */
  
  
  /*package test.tmp;
 
public class TmpSuiteListener implements ISuiteListener {
  @Override
  public void onFinish(ISuite suite) {
    System.out.println("Finishing");
  }
 
  @Override
  public void onStart(ISuite suite) {
    System.out.println("Starting");
  }
}
*/
  
  /* public class WebTestFactory {
  @Factory
  public Object[] createInstances() {
   Object[] result = new Object[10]; 
   for (int i = 0; i < 10; i++) {
      result[i] = new WebTest(i * 10);
    }
    return result;
  }
}
public class WebTest {
  private int m_numberOfTimes;
  public WebTest(int numberOfTimes) {
    m_numberOfTimes = numberOfTimes;
  }
 
  @Test
  public void testServer() {
   for (int i = 0; i < m_numberOfTimes; i++) {
     // access the web page
    }
  }
}
<class name="WebTestFactory" />
  */
  
  /* @Factory(dataProvider = "dp")
public FactoryDataProviderSampleTest(int n) {
  super(n);
}
 
@DataProvider
static public Object[][] dp() {
  return new Object[][] {
    new Object[] { 41 },
    new Object[] { 42 },
  };
}
  */

}
