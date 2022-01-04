package findingHospitals;

import java.time.Duration;
import java.util.List;

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

public class DiagnosticTopCities {
	

	//Locating the web elements using FindBy annotation
	
	@FindBy(xpath="//a[@event='Nav:Interacted:Book diagnostic tests']")
	public static WebElement diagonisticPage;

	@FindBy(xpath="//li[@class='u-text--center']/div[2]")
	public static List<WebElement> topCities;

	public static void openDiagonisticPage(WebDriver driver) throws Exception {
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Clicking the diagonistic page");
			//Log file
			Log4jFile.info("Clicking the diagonistic page");
			wait.until(ExpectedConditions.visibilityOf(diagonisticPage));
			//Highlighter option
			HighLighterOption.highlightOption(driver, diagonisticPage);
			//Clicking the diagonistic page
			diagonisticPage.click();
			//Extent report
			ExtentReport.status(Status.PASS, "Diagonistic page clicked successfully");
		} catch (Exception e) {
			System.out.println("Unable to open diagonistic page");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to open diagonistic page");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\DiagonisticPageError.png");
			//Extent report
			ExtentReport.addScreenShot(".\\Screenshots\\DiagonisticPageError.png");
			//Log file
			Log4jFile.error("Unable to open diagonistic page");
		}
	}

	public static void topCitiesNameList() throws Exception {
		try {
			//Extent report
			ExtentReport.status(Status.INFO, "Getting the top cities name");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\TopCitiesName.png");
			System.out.println("*****TOP CITIES LIST*****");
			String city;
			int size=topCities.size();
			for (int i=0;i<size;i++) {
				//Getting the list
				city = topCities.get(i).getText();
				System.out.println(city);
				//Writing the data in excel
				InputOutputExcel.writeExcel(2,i,0,city);
			}
			//Extent report
			ExtentReport.status(Status.PASS,"Top Cities list printed successfully");
			//Extent report adding screenshot
			ExtentReport.addScreenShot(".\\Screenshots\\TopCitiesName.png");
		} catch (Exception e) {
			System.out.println("Unable to get top cities list");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to get top cities list");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\topCityListError.png");
			//Extent report adding screenshot
			ExtentReport.addScreenShot(".\\Screenshots\\topCityListError.png");
			//Log file
			Log4jFile.error("Unable to get top cities list");

		}
	}

	public static void backToHomePage(WebDriver driver,String defaultWindow) {
		//Extent report
		ExtentReport.status(Status.INFO, "Navigate back to the home page");
		//Navigating back to home page
		driver.navigate().back();

	}

}
