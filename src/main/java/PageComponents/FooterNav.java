package PageComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;
public class FooterNav extends AbstractComponent {

	//WebDriver driver;
	By flights = By.cssSelector("[title=Flights]");
	By links = By.cssSelector("a");
	
	
	
	public FooterNav(WebDriver driver, By secElement) {
		
		// when you inherit parent class, you should invoke parent class constructor in child constructor
		
		super(driver, secElement); 
				
	}

	//METHOD to handle flights

	public String selectFlight() {
		
		// create custom findElement 
		
		 //findElement(flights).click();       
		// since clicking on Flight is not making any changes so we are using another check
		System.out.println("I am checking in code into git for the first time");
		return (findElement(flights).getAttribute("class"));
				
	}
	
	public int getLinksCounts() {
		return (findElements(links).size());
	}
}
