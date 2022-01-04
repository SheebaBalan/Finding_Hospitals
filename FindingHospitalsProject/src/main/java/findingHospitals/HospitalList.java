package findingHospitals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import resources.ExtentReport;
import resources.HighLighterOption;
import resources.InputOutputExcel;
import resources.Log4jFile;
import resources.TakeScreenshot;

public class HospitalList {

	//Locating the web elements using FindBy annotation

	@FindBy(xpath="//*[@id='c-omni-container']/div/div[1]/div/input")
	public static WebElement location;

	@FindBy(xpath="//*[@id='c-omni-container']/div/div[1]/div[2]/div[2]/div[1]")
	public static WebElement locationDropDown;

	@FindBy(xpath="//*[@id='c-omni-container']/div/div[2]/div/input")
	public static WebElement searchHospital;

	@FindBy(xpath="//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[3]/label/div")
	public static WebElement filter247;

	@FindBy(xpath="//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span")
	public static WebElement filterDropDown;

	@FindBy(xpath="//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[1]/div")
	public static WebElement filterHasParking;

	@FindBy(xpath="//a[@data-qa-id='pagination_next']")
	public static WebElement nextButton;

	@FindBy(className="common__star-rating__value")
	public static List<WebElement> rating;

	@FindBy(xpath="//h2[@data-qa-id='hospital_name']")
	public static List<WebElement> hospitalName;

	public static void getLocation(WebDriver driver) throws Exception {
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Selecting location as Bangalore");
			//Log file
			Log4jFile.info("Selecting location as Bangalore");
			wait.until(ExpectedConditions.visibilityOf(location));
			location.clear();
			//Highlighter option
			HighLighterOption.highlightOption(driver, location);
			//Reading data from excel file
			String locationName=InputOutputExcel.readExcel(3,1);
			location.sendKeys(locationName);
			//Highlighter option
			HighLighterOption.highlightOption(driver, locationDropDown);
			wait.until(ExpectedConditions.visibilityOf(locationDropDown));
			//Clicking the location dropdown
			locationDropDown.click();
			//Extent report
			ExtentReport.status(Status.PASS, "Location selected successfully");
		}
		catch(Exception e) {
			System.out.println("Unable to select location");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to select location");
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\locationError.png");
			//Adding the screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\locationError.png");
			//Log file
			Log4jFile.error("Unable to select location");

		}
	}

	public static void searchDoctorClinicHospitals(WebDriver driver) throws Exception {
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Selecting Hospital in the search doctor,clinic & hospital search bar");
			//Log file
			Log4jFile.info("Selecting Hospital in the search doctor,clinic & hospital search bar");
			//Highlighter option
			HighLighterOption.highlightOption(driver, searchHospital);
			//Reading the data from the excel
			String searchValue=InputOutputExcel.readExcel(4,1);
			wait.until(ExpectedConditions.visibilityOf(searchHospital));
			searchHospital.sendKeys(searchValue);
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\SearchHospital.png");
			//Robot class
			Robot robot = new Robot();
			//Pressing the enter key
			robot.keyPress(KeyEvent.VK_ENTER);
			//Releasing the enter key
			robot.keyRelease(KeyEvent.VK_ENTER);
			//Extent report
			ExtentReport.status(Status.PASS, "Hospital searched successfully");
		} catch (Exception e) {
			System.out.println("Unable to select hospital");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to select hospital");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\hospitalError.png");
			//Adding the screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\hospitalError.png");
			//Log file
			Log4jFile.error("Unable to select hospital");

		}


	}

	public static void select247CheckBox(WebDriver driver) throws Exception{
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Clicking the 24/7 checkbox");
			//Log file
			Log4jFile.info("Clicking the 24/7 checkbox");
			//Highlighter option
			HighLighterOption.highlightOption(driver, filter247);
			wait.until(ExpectedConditions.visibilityOf(filter247));
			//Clicking the 24/7 filter
			filter247.click();
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\filter247.png");
			//Extent report
			ExtentReport.status(Status.PASS, "Filter 24/7 checkbox clicked successfully");
		}catch(Exception e) {
			System.out.println("Unable to click 24/7 checkbox");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to click 24/7 checkbox");
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\checkbox247Error.png");
			//Adding the screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\checkbox247Error.png");
			//Log file
			Log4jFile.error("Unable to click 24/7 checkbox");

		}

	}

	public static void selectHasParking(WebDriver driver) throws Exception {
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Clicking the Has parking in the filter dropdown");
			//Log file
			Log4jFile.info("Clicking the Has parking in the filter dropdown");
			//Highlighter option
			HighLighterOption.highlightOption(driver, filterDropDown);
			wait.until(ExpectedConditions.visibilityOf(filterDropDown));
			//Clicking the filter dropdown
			filterDropDown.click();
			//Highlighter option
			HighLighterOption.highlightOption(driver, filterHasParking);
			wait.until(ExpectedConditions.visibilityOf(filterHasParking));
			//Clicking the parking filter
			filterHasParking.click();
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\parkingFilter.png");
			//Extent report
			ExtentReport.status(Status.PASS, "Parking filter selected successfully");
		}catch(Exception e) {
			System.out.println("Unable to click parking filter dropdown");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to click parking filter dropdown");
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\parkingFilterError.png");
			//Adding the screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\parkingFilterError.png");
			///Log file
			Log4jFile.error("Unable to click parking filter dropdown");

		}
	}

	public static void scrollPage(WebDriver driver) throws Exception {
		//Scrolling the page until all the list displayed
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=0;i<15;i++) {
			js.executeScript("arguments[0].scrollIntoView();",nextButton);
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,-100)");
			Thread.sleep(5000);
		}
	}

	public static void getHospitalName(WebDriver driver) throws Exception {
		try {
			//Extent report
			ExtentReport.status(Status.INFO, "Getting the hospital list which has more than 3.5 rating");
			//Log file
			Log4jFile.info("Getting the hospital list which has more than 3.5 rating");
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\HospitalList.png");
			int size=rating.size();
			System.out.println(size);
			System.out.println("**********Hospital List**********");
			float[] rate=new float[size];
			for(int i=0;i<size;i++) {
				rate[i]=Float.parseFloat(rating.get(i).getText());
				if(rate[i]>3.5) {
					System.out.println(hospitalName.get(i).getText());
					//Writing the data to the excel file
					InputOutputExcel.writeExcel(1,i,0,hospitalName.get(i).getText());
				}
			}
			//Extent report
			ExtentReport.status(Status.PASS, "Hospital list displayed successfully");
			//Adding the screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\HospitalList.png");
			
		}catch(Exception e) {
			System.out.println("Unable to view hospital list");
			///Extent report
			ExtentReport.status(Status.FAIL, "Unable to view hospital list");
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\hospitalListError.png");
			//Adding the screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\hospitalListError.png");
			//Log file
			Log4jFile.error("Unable to view hospital list");

		}
	}

		public static void backToHomePage(WebDriver driver) {
			//Extent report
			ExtentReport.status(Status.INFO, "Switching back to home page");
			//Switching to the default content
			driver.switchTo().defaultContent();
		}
	}


