package testngmain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class TestBase {

	private WebDriver driver;
	private RemoteWebDriver remoteDriver;

	public void setDriver(WebDriver driver) {

		// driver = new ChromeDriver();
		this.driver = driver;
	}

	public WebDriver getDriver() {

		return driver;
	}

	public void setRemoteDriver(RemoteWebDriver remoteDriver) {

		this.remoteDriver = remoteDriver;
	}

	public WebDriver getRemoteDriver() {

		return remoteDriver;
	}

	public abstract void configureDriver();

}
