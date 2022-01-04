package resources;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighterOption {
public static void highlightOption(WebDriver driver,WebElement element) throws Exception {
		
		//JavascriptExecutor class to execute javascript
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		//Set the attribute to highlight the specific webelement
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:2px soild red; background:yellow');", element);
		Thread.sleep(2000);
		//Reset to normal
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:; background:');",element);
			
	}

}
