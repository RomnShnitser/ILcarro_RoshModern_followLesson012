package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper_Base {
	//===========================================================================================
	WebDriver driver;

	// Constructor
	public Helper_Base (WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	//===========================================================================================
	public boolean isElementPresent (By locator) {
		return driver.findElements(locator).size() > 0;
	}

	//- - - - - - - - - - - - - - - - - - - - - - -
	public void type (By locator, String s) {
		WebElement element = driver.findElement(locator);

		element.click(); element.clear();
		element.sendKeys(s);
	}

	//- - - - - - - - - - - - - - - - - - - - - - -
	public void mouseClick (By locator) {
		driver.findElement(locator).click();
	}

	//- - - - - - - - - - - - - - - - - - - - - - -
	public String getText (By locator) {
		return driver.findElement(locator).getText();
	}

	public void pauseThreadSleep (int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
