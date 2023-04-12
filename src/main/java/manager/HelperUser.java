package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends Helper_Base {
	public HelperUser (WebDriver driver) {
		super(driver);
	}

	public boolean isLogged () {
		return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
	}

	public void logout () {
		mouseClick(By.xpath("//a[normalize-space()='Logout']"));
	}

	public void goHome () {
		mouseClick(By.cssSelector("a.logo"));
	}

	public void openLoginForm () {
		mouseClick(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
	}

	public void fillLoginForm (String mail, String password) {
		type(By.xpath("//input[@id='email']"), mail);
		type(By.xpath("//input[@id='password']"), password);
	}

	public void fillLoginForm (User userData) {
		type(By.xpath("//input[@id='email']"), userData.getEmail());
		type(By.xpath("//input[@id='password']"), userData.getPassword());
	}

	public void submitLogin () {
		mouseClick(By.xpath("//button[@type='submit']"));
	}

	public void clickOkButtonOnLogin () {
		mouseClick(By.xpath("//button[@type='button']"));
	}

	public boolean isLoggedSuccess () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = driver.findElement(By.cssSelector(".dialog-container"));
		wait.until(ExpectedConditions.visibilityOf(element));
//		WebElement element = (new WebDriverWait(wd,))
		return element.getText().contains("success");
	}

	public void login (User user) {
		openLoginForm();
		fillLoginForm(user);
		submitLogin();
		pauseThreadSleep(1000);
		clickOkButtonOnLogin();
		pauseThreadSleep(1000);
	}

	public void openRegistrationForm () {
		mouseClick(By.xpath("//a[text()=' Sign up ']"));
	}

	public void fillRegistrationForm (User user) {
		type(By.id("name"), user.getName());
		type(By.id("lastName"), user.getLastName());
		type(By.id("email"), user.getEmail());
		type(By.id("password"), user.getPassword());
		checkPolicy();
	}

	public void checkPolicy () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('#terms-of-use').click();");
	}

	public void submitRegistrationForm () {
		mouseClick(By.xpath("//button[@type='submit']"));
	}

	public boolean isRegistered () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='dialog-container']"))));
		return driver.findElement(By.xpath("//div[@class='dialog-container']")).getText().contains("success");
	}

	public void closeRegistration () {
		mouseClick(By.cssSelector("button.positive-button"));
	}



}
