package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;

public class HeaderNav extends AbstractComponent{

	By flights = By.cssSelector("[title=Flights]");
	By links = By.cssSelector("a");
	
	
	public HeaderNav(WebDriver driver, By secElement) {
		super(driver, secElement);
		
	}

	public String selectFlight() {
		
		// create custom findElement 
		
		 //findElement(flights).click();       // since clicking on Flight is not making any changes so we are using another check
		return (findElement(flights).getAttribute("class"));
				
	}
	
	public int getLinksCounts() {
		return (findElements(links).size());
	}
}
