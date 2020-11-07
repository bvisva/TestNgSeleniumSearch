package testngenvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EnvironmentSetup {
	
	
	private static String chromeSystemUrlKey = "webdriver.chrome.driver";
	private static String chromeSystemUrlValue = "C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\chromedriver.exe";
	//private WebDriver chromeWebDriver;
	private static String firefoxSystemUrlKey = "webdriver.gecko.driver";
	private static String firefoxSystemUrlValue = "C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\geckodriver.exe";
	
	private static String remoteBrowserName = "chrome";
	private static String remotePlatformName = "win10";
	private static String remoteBrowserVersion = "77.0";
	private static String remoteUrlString = "http://localhost:4444/wd/hub"; 
	
	private static WebDriver returnWebDriver;
	private static RemoteWebDriver remoteWebDriver; 
	
	public static WebDriver getDriverSetup(String browser) {
		
		  switch(browser){  
		    
		    case "Chrome":
		    returnWebDriver = new ChromeDriver();  
		    break;  
		    
		    case "Firefox": 
		    returnWebDriver = new FirefoxDriver();  
		    break;  
		    
		    default: 
		    	returnWebDriver = new ChromeDriver();		    
		    }
		 
		 return returnWebDriver;
		
		
	}
	
   public static WebDriver getDriverSetupWithSystem(String browser) {
	   switch(browser){  
	    
	    case "Chrome":
	    System.setProperty(chromeSystemUrlKey,chromeSystemUrlValue);
	    returnWebDriver = new ChromeDriver();  
	    break;  
	    
	    case "Firefox": 
	    System.setProperty(firefoxSystemUrlKey,firefoxSystemUrlValue);
		returnWebDriver = new FirefoxDriver();  
	    break;  
	    
	    default: 
	    returnWebDriver = new ChromeDriver();		    
	    }
	 
	 return returnWebDriver;
	    
		
		
	}
   
   
    public static RemoteWebDriver getRemoteDriverSetup() throws MalformedURLException {
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("browserName", remoteBrowserName);
        capabilities.setCapability("version", remoteBrowserVersion);
        capabilities.setCapability("platform", remoteBrowserVersion);
    	remoteWebDriver = new RemoteWebDriver(new URL(remoteUrlString),capabilities);
    	return remoteWebDriver;   	
    	
		
    }
    
  /*  
  //Setting up capabilities to run our test script
    @BeforeClass
    	public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "77.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs

 capabilities.setCapability("selenium_version","4.0.0-alpha-2");
         capabilities.setCapability("timezone","UTC+05:30");
         capabilities.setCapability("geoLocation","IN");
         capabilities.setCapability("chrome.driver","78.0");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
    }*/
    
    
   /* DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName","SM-A507FN");
    capabilities.setCapability("udid", "RZ8M92JZ6PB");
    capabilities.setCapability("platformName","Android");
    capabilities.setCapability("platformVersion", "10");
    capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
    capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
    URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");*/
	
	
	/*public static WebDriver getBrowserUrlDriver(String uri) {
		
		 switch(uri){  
		    
		    case "Chrome":
		    System.setProperty(chromeSystemUrlKey,chromeSystemUrlValue);
		    returnWebDriver = new ChromeDriver();  
		    break;  
		    
		    case "Firefox": 
		    System.setProperty(firefoxSystemUrlKey,firefoxSystemUrlValue);
			returnWebDriver = new FirefoxDriver();  
		    break;  
		    
		    default: 
		    returnWebDriver = new ChromeDriver();		    
		    }
		 
		 return returnWebDriver;
		    
		
	}*/

}
