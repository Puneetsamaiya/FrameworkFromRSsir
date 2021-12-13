package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class AbstractComponent {

	WebElement secElement;
	WebDriver driver;
	WebDriverWait wait;
	
	
	public AbstractComponent(WebDriver driver, By secElement) {
		this.driver = driver;
		this.secElement =driver.findElement(secElement);
		 
	}
	
	public WebElement findElement(By findElementBy) {
		
		return secElement.findElement(findElementBy);
	}
	
	public List<WebElement> findElements(By findElementBy) {
		
		return secElement.findElements(findElementBy);
	}
		
	public void waitForElementToDisapper(By elementToWait) {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementToWait));
	}
}
