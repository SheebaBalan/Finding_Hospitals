package findingHospitals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import resources.InputOutputExcel;


public class DriverSetup {

	static WebDriver driver;


	public static WebDriver getWebDriver() throws Exception {

		String browser=InputOutputExcel.readExcel(0,2);
		if(browser.equalsIgnoreCase("Chrome")) {
			//If it is 1,It open the chrome browser
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();	
			

		}
		else if(browser.equalsIgnoreCase("Edge")) {
			//If it is 2 ,It open the firefox browser
			System.setProperty("webdriver.edge.driver",".\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			

		} 
		else {
			//If it is not 1 or 2,it print the message
			System.out.println("Invalid input.");
			System.out.println("Enter the correct value: ");
			//Return to first statement  to get the correct input
			DriverSetup.getWebDriver();

		}
		//return the driver
		return driver;

	}
}
