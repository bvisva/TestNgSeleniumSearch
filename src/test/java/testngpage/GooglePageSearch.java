package testngpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePageSearch {
	private WebDriver _driver; 
	private By waitForSearchButton = By.xpath("//input[@name = 'btnK']");	
	
		
	public GooglePageSearch(WebDriver driver){
		//super(driver);
		this._driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@name = 'q']") WebElement searchTextBox;
	@FindBy(how=How.XPATH, using="//input[@name = 'btnK']") WebElement searchButton;
	@FindBy(how=How.XPATH, using="//*[@id=\"rso\"]/div[@class='g']") List<WebElement> searchResultsList;
	
	
	public void openGoogleIndia(){
		_driver.get("https://www.google.co.in/");
		_driver.manage().window().maximize();
	}
	
	public void inputSearchText(String txtGoogleSearch) {
		searchTextBox.sendKeys(txtGoogleSearch);
	}
	
	public void clickGoogleSearch() {
		WebDriverWait wait = new WebDriverWait(_driver,10);
		WebElement searchGoogleBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(waitForSearchButton));
		searchGoogleBtn.click();
				
	}//searchButton.click();
	
	public void displaySearchResults() {
		
		for(WebElement searchResult:searchResultsList) {
			
		 WebElement searchLink = searchResult.findElement(By.xpath(".//div[@class='rc']/div[@class='yuRUbf']/a"));
		 WebElement searchLinkHead = searchResult.findElement(By.xpath(".//div[@class='rc']/div[@class='yuRUbf']/a/h3/span"));
		 System.out.println(searchLink.getAttribute("href")+"  -  "+ searchLinkHead.getText());
		}
	
		System.out.println(searchResultsList.size()); 
		
	}
	
	public void closeGoogleIndia() {
		_driver.quit();
	}	

}
