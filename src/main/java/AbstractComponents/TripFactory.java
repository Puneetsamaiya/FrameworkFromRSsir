package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageComponents.MultiTrip;
import PageComponents.RoundTrip;
import PageObjects.BaseTravelHomePage;

public class TripFactory {

    //****************---Factory Design Pattern---**************
    
    
	//BaseTravelHomePage baseHomePage = new BaseTravelHomePage();
	
	By flightSearchSection = By.id("flightSearchContainer");
	WebDriver driver; //= baseHomePage.driver; 
	
	public TripFactory(WebDriver driver2) {
		this.driver = driver2;
	}

	public SearchFlightAvail selectTrip(String trip) {
		
		if(trip.equalsIgnoreCase("multitrip")) {
			
			return new MultiTrip(driver,flightSearchSection);
		}
		if(trip.equalsIgnoreCase("roundtrip")) {
			
			return new RoundTrip(driver,flightSearchSection);
		}
		return null;
	}
}
