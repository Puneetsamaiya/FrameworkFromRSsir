package PageComponents;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;
import AbstractComponents.SearchFlightAvail;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail{

	public RoundTrip(WebDriver driver, By secElement) {
		super(driver, secElement);
		
	}

	private By roundTripRadio = By.id("ctl00_mainContent_rbtnl_Trip_1");
	
	private By fromDropDown = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	
	private By checkBoxIndianArmedForced = By.id("ctl00_mainContent_chk_IndArm");
	
	private By searchButton = By.id("ctl00_mainContent_btn_FindFlights");
	
	private By toDropDown = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	
	@Override
	public void checkAvail(HashMap<String, String> reservationDetails) {
		
		System.out.println("Class RoundTrip");
		
		findElement(roundTripRadio).click();  
		
		System.out.println("RoundTripClicked");
							
		//Select the Origin City
		selectOriginCity(reservationDetails.get("origin"));  
		
		System.out.println("From City Selected:-->"+reservationDetails.get("origin"));
		
		selectDestinationCity(reservationDetails.get("destination")); 
		
		System.out.println("Destination City Selected"+reservationDetails.get("destination"));
		
				
		findElement(checkBoxIndianArmedForced).click();
		
		System.out.println("CheckBox Selected");
		
		
		findElement(searchButton).click();
		
		System.out.println("searchButton Clicked");
		
	}
	
	public void selectOriginCity(String originCity) {
		
		findElement(fromDropDown).click();
		findElement(By.xpath("//a[@value='"+originCity+"']")).click();
	}


	  public void selectDestinationCity(String destinationCity) {
	  
		  findElement(toDropDown).click();
	  
		  System.out.println(destinationCity);
	  	  
		  findElement(By.xpath("(//a[@value='"+destinationCity+"'])[2]")).click(); 
	  
	  }
	 
}
