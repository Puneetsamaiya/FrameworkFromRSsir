package TestComponents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageComponents.MultiTrip;
import PageComponents.RoundTrip;
import PageObjects.BaseTravelHomePage;
import dataLoads.DataReader1;

public class DemoTestClass extends DataReader1{

	BaseTravelHomePage basePage = new BaseTravelHomePage();
	//WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void fligtTest(HashMap<String,String> reservationDetails) {
		
		basePage.goTo();
	
	//System.out.println(basePage.getFooterNav().selectFlight());
		
	//System.out.println(basePage.getNavigationBar().selectFlight());
		
	//System.out.println(basePage.getFooterNav().getLinksCounts());
		
	//System.out.println(basePage.getNavigationBar().getLinksCounts());
		
	//RoundTrip Constructor values with Driver and section element 
	 
	//basePage.setBookingStrategy(new RoundTrip(basePage.driver,By.id("flightSearchContainer"))); 
	  
		basePage.setBookingStrategy("multitrip");
		
		basePage.checkAvail(reservationDetails);
	 
		
	//MultiTrip Constructor values with Driver and section element 
		
		try { Thread.sleep(2000); } catch (InterruptedException e) {  e.printStackTrace(); }
		
		basePage.driver.navigate().refresh();
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
		
	//basePage.setBookingStrategy(new MultiTrip(basePage.driver, By.id("flightSearchContainer"))); 
		
		basePage.setBookingStrategy("Roundtrip");
		basePage.checkAvail(reservationDetails);
		
	}
	
	
	//*&*&*&*&*&*&*&*&      *&*&*&*&*&*&*&*&       *&*&*&*&*&*&*&*&//
	//*&*&*&*&                                               *&*&*&//
	//*&*&*  Parameterized with HashMap using data provider    *&*&//
	//*&*&*&*&                                               *&*&*&//
	//*&*&*&*&*&*&*&*&       *&*&*&*&*&*&*&*&      *&*&*&*&*&*&*&*&//
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		/*
		 * HashMap<String, String> reservationDetails = new HashMap<String, String>();
		 * HashMap<String, String> reservationDetails2 = new HashMap<String, String>();
		 * reservationDetails.put("origin", "MAA");
		 * reservationDetails.put("destination", "HYD");
		 * reservationDetails.put("destination2", "BLR");
		 * 
		 * reservationDetails2.put("origin", "DEL");
		 * reservationDetails2.put("destination", "HYD");
		 * reservationDetails2.put("destination2", "MAA");
		 * 
		 * List<HashMap<String, String >> l = new ArrayList<HashMap<String, String>>();
		 * 
		 * l.add(reservationDetails); l.add(reservationDetails2);
		 */
		
		//Through the dataReader Class we are going to use getJsonData method to get the data here
		
		List<HashMap<String, String >> l = 
				
				getJsonData(System.getProperty("user.dir")+"//src//test//java//dataLoads//ReservationDetails.json");
		
		return new Object[][] {
			
			{l.get(0)} , 
			
			{l.get(1)}
		};
	}
	
}
