package PageComponents;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;
import AbstractComponents.SearchFlightAvail;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class MultiTrip extends AbstractComponent  implements SearchFlightAvail{

	
	public MultiTrip(WebDriver driver, By secElement) {
		super(driver, secElement);
		
	}


	private By multiCityRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
	private By fromDropDown = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	
	//private By checkBoxIndianArmedForced = By.id("ctl00_mainContent_chk_IndArm");
	
	private By searchButton = By.id("ctl00_mainContent_btn_FindFlights");
	
	private By toDropDown = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	
	private By fromDropDown2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
	
	private By modelAlert = By.id("MultiCityModelAlert");
	
	
	@Override
	public void checkAvail(HashMap<String, String> reservationDetails) {
		
//		System.out.println("****** l ******");
//		System.out.println("****** l ******");
//		System.out.println("****** l ******");	
		
		System.out.println("Class MultiTrip ");
//		findElement(multiCityRadio).click();
//		findElement(modelAlert).click();
		
//		selectOriginCity(origin);
		
		//******************Execute Around Design Pattern************************
		
		
		makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
		
		selectDestinationCity(reservationDetails.get("destination"));
		selectDestinationCity2(reservationDetails.get("destination2"));
		
		findElement(searchButton).click();
		
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
	  
	  public void selectDestinationCity2(String destinationCity2) {
		  
		  findElement(fromDropDown2).click();
	  
		  System.out.println(destinationCity2);
	  
		  findElement(By.xpath("(//a[@value='"+destinationCity2+"'])[3]")).click(); 
	  
	  }  
	  
	  public void makeStateReady(Consumer<MultiTrip> consumer) {
		  
			System.out.println("****** l ******");
			System.out.println("****** l ******");
			System.out.println("****** l ******");	
			
			
			findElement(multiCityRadio).click();
			findElement(modelAlert).click();
			
			waitForElementToDisapper(modelAlert);  // Explicitly wait
			
			
			consumer.accept(this);    // ******************** Execute around pattern ******* uses Lambda Expression
			System.out.println("I am done from multicity");
	  }


	
	
}
