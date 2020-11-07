package testngmain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testngenvironment.EnvironmentSetup;
import testngpage.GooglePageSearch;
import testngtestdata.GoogleSearchPageData;

public class GoogleSearch extends TestBase {

	WebDriver driver = null;
	private GooglePageSearch searchGooglePage = null;

	@Override
	public void configureDriver() {
		// TODO Auto-generated method stub
		setDriver(EnvironmentSetup.getDriverSetup("Chrome"));
		driver = getDriver();

	}

	public GoogleSearch() {
		// super(driver);
		// driver = new ChromeDriver();

		// searchGooglePage = PageFactory.initElements(driver, GoogleSearchPage.class);
	}

	@Test(description = "Gets the list of links based on search")
	public void googleSearchResult() {

		searchGooglePage.openGoogleIndia();
		searchGooglePage.inputSearchText(GoogleSearchPageData.searchText);
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

		// driver = new ChromeDriver();
		configureDriver();
		searchGooglePage = PageFactory.initElements(driver, GooglePageSearch.class);

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
