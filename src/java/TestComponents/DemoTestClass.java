package TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import PageObjects.BaseTravelHomePage;

public class DemoTestClass {

	
	BaseTravelHomePage basePage = new BaseTravelHomePage();
	WebDriver driver;
	@Test
	public void flightTest() {
		
		basePage.goTo();
		basePage.getFooterNav().selectFlight();
	}
	
}
