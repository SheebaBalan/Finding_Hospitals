package findingHospitals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import resources.ExtentReport;
import resources.HighLighterOption;
import resources.InputOutputExcel;
import resources.Log4jFile;
import resources.TakeScreenshot;

public class CorporateWellness {
	

	//Locating the web elements using FindBy annotation
	
	@FindBy(xpath="	//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span[1]")
	public static WebElement providerDropDown;

	@FindBy(xpath="//a[text()='Corporate wellness']")
	public static WebElement corporateWellness;

	@FindBy(id="name")
	public static WebElement name;

	@FindBy(id="organization_name")
	public static WebElement organization;

	@FindBy(id="official_email_id")
	public static WebElement email;

	@FindBy(id="official_phone_no")
	public static WebElement phoneNumber;

	@FindBy(xpath="//select[@id='organization_size']")
	public static WebElement organizationDropdown;

	@FindBy(xpath="//button[@type='submit']")
	public static WebElement submitButton;

	@FindBy(id="thankyou-section")
	public static WebElement message;

	public static void clickProviderDropDown(WebDriver driver) throws Exception {
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Clicking the provider dropdown");
			//Log file
			Log4jFile.info("Clicking the provider dropdown");
			wait.until(ExpectedConditions.visibilityOf(providerDropDown));
			//Highlighter option
			HighLighterOption.highlightOption(driver, providerDropDown);
			//Clicking the provider dropdown
			providerDropDown.click();
			//Extent report
			ExtentReport.status(Status.PASS, "Provider dropdown successfully clicked");
		}catch(Exception e) {
			System.out.println("Unable to select provider dropdown");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to select provider dropdown");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\providerError.png");
			//Adding screenshot in extent report
			ExtentReport.addScreenShot(".\\Screenshots\\providerPageError.png");
			//Log file
			Log4jFile.error("Unable to select provider dropdown");

		}
	}

	public static void clickCorporateWellness(WebDriver driver) throws Exception {

		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Clicking Corporate wellness from the provider dropdown");
			//Log file
			Log4jFile.info("Clicking Corporate wellness from the provider dropdown");
			//Highlighter option
			HighLighterOption.highlightOption(driver, corporateWellness);
			wait.until(ExpectedConditions.visibilityOf(corporateWellness));
			//Clicking the corporate wellness from the provider dropdown
			corporateWellness.click();
			//Extent report
			ExtentReport.status(Status.PASS, "Corporate Wellness successfully clicked");
			Set<String> windowHandles=driver.getWindowHandles();
			for (String newWindow : windowHandles) {
				//Switching to the child window
				driver.switchTo().window(newWindow);
			}
		} catch (Exception e) {
			System.out.println("Unable to select corporate wellness");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to select corporate wellness");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\corporateError.png");
			//Adding screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\corporateError.png");
			//Log file
			Log4jFile.error("Unable to select corporate wellness");
		}


	}

	public static void ValidDetails(WebDriver driver) throws Exception {

		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Filling valid details in the form");
			//Log file
			Log4jFile.info("Filling valid details in the form");
			wait.until(ExpectedConditions.visibilityOf(name));
			//Highlighter option
			HighLighterOption.highlightOption(driver, name);
			//Reading value from the excel sheet
			String nameValue=InputOutputExcel.readExcel(7,1);
			name.sendKeys(nameValue);
			//Highlighter option
			HighLighterOption.highlightOption(driver, organization);
			//Reading value from the excel sheet
			String organizationValue=InputOutputExcel.readExcel(8,1);
			organization.sendKeys(organizationValue);
			//Highlighter option
			HighLighterOption.highlightOption(driver, email);
			//Reading value from the excel sheet
			String emailValue=InputOutputExcel.readExcel(9,1);
			email.sendKeys(emailValue);
			//Highlighter option
			HighLighterOption.highlightOption(driver, phoneNumber);
			//Reading value from the excel sheet
			String phone=InputOutputExcel.readExcel(10,1);
			phoneNumber.sendKeys(phone);
			//Highlighter option
			HighLighterOption.highlightOption(driver, organizationDropdown);
			//Select class for dropdown
			Select dropdown=new Select(organizationDropdown);
			//Reading value from the excel sheet
			int index=Integer.parseInt(InputOutputExcel.readExcel(11,1));
			dropdown.selectByIndex(index);
			//Highlighter option
			HighLighterOption.highlightOption(driver, submitButton);
			//Clicking the submit button
			submitButton.click();
			wait.until(ExpectedConditions.visibilityOf(message));
			System.out.println("**********Corporate Wellness Message**********");
			System.out.print(message.getText());
			//Writing data to the excel file
			InputOutputExcel.writeExcel(2,11,0,message.getText());
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\validDetails.png");
			//Extent report
			ExtentReport.status(Status.PASS, "Form successfully filled");
			//Adding screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\validDetails.png");
		} catch (Exception e) {
			System.out.println("Unable to fill valid details");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to fill valid details");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\validError.png");
			//Adding screenshot to the extent report
			ExtentReport.addScreenShot(".\\Screenshots\\validError.png");
			//Log file
			Log4jFile.error("Unable to fill valid details");
		}

	}
	public static void invalidMailDetails(WebDriver driver) throws Exception {
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent repport
			ExtentReport.status(Status.INFO, "Filling invalid email in the form");
			//Log file
			Log4jFile.info("Filling invalid email in the form");
			//Refreshing the window
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(name));
			//Highlighter option
			HighLighterOption.highlightOption(driver, name);
			//Reading value from the excel sheet
			String nameValue=InputOutputExcel.readExcel(7,1);
			name.sendKeys(nameValue);
			//Highlighter option
			HighLighterOption.highlightOption(driver, organization);
			//Reading value from the excel sheet
			String organizationValue=InputOutputExcel.readExcel(8,1);
			organization.sendKeys(organizationValue);
			//Highlighter option
			HighLighterOption.highlightOption(driver, email);
			//Reading value from the excel sheet
			String emailValue=InputOutputExcel.readExcel(14,1);
			email.sendKeys(emailValue);
			//Highlighter option
			HighLighterOption.highlightOption(driver, phoneNumber);
			//Reading value from the excel sheet
			String phone=InputOutputExcel.readExcel(10,1);
			phoneNumber.sendKeys(phone);
			//Highlighter option
			HighLighterOption.highlightOption(driver, organizationDropdown);
			//Select class for dropdown
			Select dropdown=new Select(organizationDropdown);
			//Reading value from the excel sheet
			int index=Integer.parseInt(InputOutputExcel.readExcel(11,1));
			dropdown.selectByIndex(index);
			//Highlighter option
			HighLighterOption.highlightOption(driver, submitButton);
			//Clicking the submit button
			submitButton.click();
			//Wait for 20 sec to do the captcha manually
			Thread.sleep(20000);
			//Extent report
			ExtentReport.status(Status.PASS, "Successfully alert message captured");
			//Taking screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\invalidMail.png");
			//Adding screenshot to extent report
			ExtentReport.addScreenShot(".\\Screenshots\\invalidMail.png");
			//Robot class
			Robot robot=new Robot();
			//Pressing the enter button
			robot.keyPress(KeyEvent.VK_ENTER);
			//Releasing the enter button
			robot.keyRelease(KeyEvent.VK_ENTER);
			/*Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(5000);
			alert.accept();
			ExtentReport.status(Status.PASS, "Alert is present");*/
		} catch (Exception e) {
			System.out.println("Unable to capture alert message");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to capture alert message");
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\InvalidMailError.png");
			//Adding screenshot to extent report
			ExtentReport.addScreenShot(".\\Screenshots\\InvalidMailError.png");
			//Log file
			Log4jFile.error("Unable to capture alert message");
		}

	}


	public static void invalidPhoneDetails(WebDriver driver) throws Exception {
		try {
			//Explicit wait
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(2));
			//Extent report
			ExtentReport.status(Status.INFO, "Filling invalid phone number in the form");
			//Log file
			Log4jFile.info("Filling invalid phone number in the form");
			wait.until(ExpectedConditions.visibilityOf(email));
			email.clear();
			//Highlighter option
			HighLighterOption.highlightOption(driver, email);
			//Reading the data from excel file
			String emailValue=InputOutputExcel.readExcel(9,1);
			email.sendKeys(emailValue);
			phoneNumber.clear();
			//Highlighter option
			HighLighterOption.highlightOption(driver, phoneNumber);
			//Reading data from excel file
			String phone=InputOutputExcel.readExcel(17,1);
			phoneNumber.sendKeys(phone);
			//Highlighter option
			HighLighterOption.highlightOption(driver, submitButton);
			//Clicking the submit button
			submitButton.click();
			//Wait for 20 sec to do the captcha manually
			Thread.sleep(20000);
			//Extent report
			ExtentReport.status(Status.PASS, "Form successfully filled");
			TakeScreenshot.takeScreenshot(".\\Screenshots\\invalidPhone.png");
			//Adding screenshot to extent report
			ExtentReport.addScreenShot(".\\Screenshots\\invalidPhone.png");
			//Robot class
			Robot robot=new Robot();
			//Pressing the enter key
			robot.keyPress(KeyEvent.VK_ENTER);
			//Releasing the enter key
			robot.keyRelease(KeyEvent.VK_ENTER);
			/*Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(5000);
			alert.accept();
			ExtentReport.status(Status.PASS, "Alert is present");*/
		} catch (Exception e) {
			System.out.println("Unable to capture alert message");
			//Extent report
			ExtentReport.status(Status.FAIL, "Unable to capture alert message");
			//Taking the screenshot
			TakeScreenshot.takeScreenshot(".\\Screenshots\\InvalidPhoneError.png");
			//Adding the screenshot to the extent file
			ExtentReport.addScreenShot(".\\Screenshots\\InvalidPhoneError.png");
			//Log file
			Log4jFile.error("Unable to capture alert message");
		}


	}

	public static WebDriver backToHomePage(WebDriver driver) {
		
		//Switching to default content
		driver.switchTo().defaultContent();
		//Extent report
		ExtentReport.status(Status.INFO, "Navigate back to home page");
		return driver;

	}


}
