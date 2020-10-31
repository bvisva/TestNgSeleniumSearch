package testngmain;

import org.testng.annotations.Test;

import testngpages.AmazonSearchPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class AmazonSearch {
  
   WebDriver driver = null;	
   AmazonSearchPage amazonSearchPage = null;
	
  @Test(description="Gets the list of products based on search categroy")
  public void amazonSearchResult() {  			
		amazonSearchPage.openAmazonIndia();
		amazonSearchPage.selectProductCategory("search-alias=electronics");
		amazonSearchPage.inputSearchText("headphones with mic");
		amazonSearchPage.clickSearchButton();
		amazonSearchPage.getProductLists();
		//amazonSearchPage.insertProductListDatabase();	  
  }
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  //System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
		
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
