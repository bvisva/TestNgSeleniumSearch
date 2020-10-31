package testngpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearchPage {
	
	private WebDriver _driver;
	private List<String> searchResults = new ArrayList<String>();
	
	
	public AmazonSearchPage(WebDriver driver){
		this._driver=driver;
	}
	
	@FindBy(how=How.ID, using="searchDropdownBox") WebElement searchCategoryDropdown;
	@FindBy(how=How.ID, using="twotabsearchtextbox") WebElement searchTextbox;
	@FindBy(how=How.XPATH, using="//*[@id=\"nav-search-submit-text\"]/input") WebElement searchSubmitButton;
	@FindBy(how=How.XPATH, using="//*[@id=\"search\"]//span[@data-component-type='s-search-results']/div[2]/div") List<WebElement> productResultsList;
	
	public void openAmazonIndia(){
		_driver.get("https://www.amazon.in/");
		_driver.manage().window().maximize();
	}
	
	public void selectProductCategory(String categoryValue) {
		Select searchCategory = new Select(searchCategoryDropdown);
		searchCategory.selectByValue(categoryValue);
	}
	
	public void inputSearchText(String searchTextValue) {
		searchTextbox.sendKeys(searchTextValue);
	}
	
	public void clickSearchButton() {
		searchSubmitButton.click();
	}
	
	public void getProductLists() {
		
		String tempattr;
		for(WebElement element:productResultsList) {
			if(element.getAttribute("data-asin") != null && !element.getAttribute("data-asin").isEmpty()) { 
				tempattr = "";
				tempattr = element.getAttribute("data-asin");
				WebElement productDescription = _driver.findElement(By.xpath("//*[@id=\"search\"]//span[@data-component-type='s-search-results']/div[2]/div[@data-asin='"+tempattr+"']//h2/a/span"));
				searchResults.add(productDescription.getText());
				System.out.println(productDescription.getText());
		    }
		}
		
	}
	
	public void insertProductListDatabase() {
		
	} 
	
	
	public void closeAmazonIndia() {
		_driver.quit();
	}
	
	

}

/*Select searchCategory = new Select(driver.findElement(By.id("searchDropdownBox")));
searchCategory.selectByValue("search-alias=electronics");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("headphones with mic");
driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
//*[@id="nav-search-submit-text"]/input
//List<WebElement> elements = driver.findElements(By.xpath("//*[@data-component-type='sp-sponsored-result']"));

List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div"));


WebDriver driver;
public FbHomePage(WebDriver driver){
this.driver=driver;
}
//Using FindBy for locating elements
@FindBy(how=How.XPATH, using="//div") WebElement profileDropdown;
@FindBy(how=How.XPATH, using="//text()[.='Log Out']/ancestor::span[1]") WebElement logoutLink;

TestCase*/
