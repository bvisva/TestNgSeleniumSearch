package testngmain;

import org.testng.annotations.Test;
import testngpages.GoogleSearchPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class GoogleSearch {
	
  WebDriver driver = null;	
  GoogleSearchPage searchGooglePage = null;
	
  @Test(description="Gets the list of links based on search")
  public void googleSearchResult() {	  
	    
		searchGooglePage.openGoogleIndia();
		searchGooglePage.inputSearchText("Selenium Tutorial");
		searchGooglePage.clickGoogleSearch();
		searchGooglePage.displaySearchResults();		
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  
		driver = new ChromeDriver();
	  searchGooglePage = PageFactory.initElements(driver, GoogleSearchPage.class);
	  
  }

  @AfterClass
  public void afterClass() {
	 driver.close();
  }

}
