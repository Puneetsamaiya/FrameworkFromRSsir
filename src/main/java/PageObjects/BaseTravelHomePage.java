package PageObjects;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.SearchFlightAvail;
import AbstractComponents.TripFactory;
import BrowserDrivers.RequestBrowserDriver;
import PageComponents.FooterNav;
import PageComponents.HeaderNav;

public class BaseTravelHomePage {
 
	RequestBrowserDriver requestBrowser = new RequestBrowserDriver();
	
	By footerSection= By.id("traveller-home");
	By headerSection = By.id("buttons"); 	
	
	public WebDriver driver = requestBrowser.init_Driver();
	
	SearchFlightAvail searchFlight; //variable for interface
	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	public HeaderNav getNavigationBar() {
		
		return new HeaderNav(driver, headerSection);
	}
	
	public FooterNav getFooterNav() {
		
		return new FooterNav(driver, footerSection);
	}
	
	public void setBookingStrategy(String tripType) {
		
		
		TripFactory tripFactoryObj = new TripFactory(driver);
		
		searchFlight = tripFactoryObj.selectTrip(tripType);
	} 

	public void checkAvail(HashMap<String, String> reservationDetails) {
	
		searchFlight.checkAvail(reservationDetails);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
}
