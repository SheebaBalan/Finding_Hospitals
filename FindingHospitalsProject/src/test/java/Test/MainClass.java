package Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import findingHospitals.CorporateWellness;
import findingHospitals.DiagnosticTopCities;
import findingHospitals.DriverSetup;
import findingHospitals.HospitalList;
import resources.ExtentReport;
import resources.Log4jFile;

public class MainClass {

	WebDriver driver;
	
	@BeforeSuite
	public void getBrowser() throws Exception {
		//Extent report
		ExtentReport.report();
		//Log file
		Log4jFile.logger=Logger.getLogger(DriverSetup.class.getName());
		Log4jFile.log();
		Log4jFile.info("Launching the browser and opening the practo.com");
		//Calling the Driver setup
		driver=DriverSetup.getWebDriver();
		//Getting the practo.com website
		driver.navigate().to("https://www.practo.com/");
		//Maximizing the window
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void hospitalList() throws Exception {
		//Extent report
		ExtentReport.createTestcase("Getting Hospital List which is in Bangalore and that is Open 24/7, has Parking facility with rating more than 3.5");
		//Log file
		Log4jFile.logger=Logger.getLogger(HospitalList.class.getName());
		Log4jFile.log();
		Log4jFile.info("Getting Hospital List which is in Bangalore and that is Open 24/7, has Parking facility with rating more than 3.5");
		//Page factory
		PageFactory.initElements(driver, HospitalList.class);
		//Calling the methods
		HospitalList.getLocation(driver);
		HospitalList.searchDoctorClinicHospitals(driver);
		HospitalList.select247CheckBox(driver);
		HospitalList.selectHasParking(driver);
		HospitalList.scrollPage(driver);
		HospitalList.getHospitalName(driver);
		HospitalList.backToHomePage(driver);
	}

	@Test(priority=2)
	public void topCitiesList() throws Exception {
		//Extent report
		ExtentReport.createTestcase("Getting all the top cities name in Diagnostics page");
		//Log file
	    Log4jFile.logger=Logger.getLogger(DiagnosticTopCities.class.getName());
		Log4jFile.log();
		Log4jFile.info("Getting all the top cities name in Diagnostics page");
		//Page factory
		PageFactory.initElements(driver, DiagnosticTopCities.class);
		//Calling the methods
		DiagnosticTopCities.openDiagonisticPage(driver);
		String defaultWindow=driver.getWindowHandle();
		DiagnosticTopCities.topCitiesNameList();
		DiagnosticTopCities.backToHomePage(driver,defaultWindow);
	}

	@Test(priority=3)
	public void corporateWellness() throws Exception {
		//Extent report
		ExtentReport.createTestcase("Filling Valid and Invalid details,schedule & capture the warning message from the alert  in the Corporate Wellness page");
		//Log file
		Log4jFile.logger=Logger.getLogger(CorporateWellness.class.getName());
		Log4jFile.log();
		Log4jFile.info("Filling Valid and Invalid details,schedule & capture the warning message from the alert  in the Corporate Wellness page");
		//Page factory
		PageFactory.initElements(driver, CorporateWellness.class);
		//Calling the methods
		CorporateWellness.clickProviderDropDown(driver);
		CorporateWellness.clickCorporateWellness(driver);
		CorporateWellness.ValidDetails(driver);
		CorporateWellness.invalidMailDetails(driver);
		CorporateWellness.invalidPhoneDetails(driver);
		driver=CorporateWellness.backToHomePage(driver);

	}

	@AfterSuite
	public void closeBrowser() {
		//Quiting the driver
		driver.quit();
		//Extent report
		ExtentReport.writeReport();
	}


}
