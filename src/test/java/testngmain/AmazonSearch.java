package testngmain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testngenvironment.EnvironmentSetup;
import testngpage.AmazonPageSearch;
import testngtestdata.AmazonSearchPageData;

public class AmazonSearch extends TestBase {

	WebDriver driver = null;
	AmazonPageSearch amazonSearchPage = null;

	@Override
	public void configureDriver() {
		// TODO Auto-generated method stub
		setDriver(EnvironmentSetup.getDriverSetup("Chrome"));
		driver = getDriver();

	}

	@Test(description = "Gets the list of products based on search categroy")
	public void amazonSearchResult() {

		amazonSearchPage.openAmazonIndia();
		amazonSearchPage.selectProductCategory(AmazonSearchPageData.productCategory);
		amazonSearchPage.inputSearchText(AmazonSearchPageData.searchText);
		amazonSearchPage.clickSearchButton();
		amazonSearchPage.getProductLists();

		// amazonSearchPage.insertProductListDatabase();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\DELL\\eclipse-workspace\\BrowserDrivers\\chromedriver.exe");
		// driver = new ChromeDriver();
		// amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
		// driver = new ChromeDriver();
		configureDriver();
		amazonSearchPage = PageFactory.initElements(driver, AmazonPageSearch.class);

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
