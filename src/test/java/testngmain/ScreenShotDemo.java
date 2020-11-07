package testngmain;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ScreenShotDemo {
	
	WebDriver driver = null;	
	
	
	@Test
	public void takeScreenCapture() throws InterruptedException, IOException {
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  Thread.sleep(5);
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  String path=System.getProperty("user.dir")+"/target/Spark/"+System.currentTimeMillis()+".png";
		  //String imageFile = "./target/Spark/Images/"+"result"+".png"; 		  
		  FileHandler.copy(src, new File(path));
		  System.out.println("sucess screen capture");
		
	}
	
	@BeforeClass
	  public void beforeClass() {
		  //System.setProperty("webdriver.chrome.driver",
					//"C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			//amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
		  driver = new ChromeDriver();
		  //amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
			
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
