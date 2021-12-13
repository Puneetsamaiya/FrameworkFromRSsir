package BrowserDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RequestBrowserDriver {
	public WebDriver driver;
	ChromeOptions chromeOptions = new ChromeOptions();


	public WebDriver init_Driver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		return driver;

	}
	
	
}
