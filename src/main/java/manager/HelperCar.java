package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperCar extends Helper_Base {
	public HelperCar (WebDriver driver) {
		super(driver);
	}

	public void openCarForm () {
		pauseThreadSleep(2000);
		mouseClick(By.xpath("(//a[@id='1'])[1]"));
	}

	public void fillCarForm (Car car) {
		typeLocation(car.getAddress());
		type(By.id("make"), car.getMake());
		type(By.id("model"), car.getModel());
		type(By.id("year"), car.getYear());
		select(By.id("fuel"), car.getFuel());
		type(By.id("seats"), car.getSeats());
		//type(By.id("class"), car.getCarClass());
		type(By.id("classs"), car.getCarClass());
		type(By.id("serialNumber"), car.getCarRegNumber());
		type(By.id("price"), car.getPrice());
	}

	private void select (By locator, String option) {
		new Select(driver.findElement(locator)).selectByValue(option);
	}

	private void typeLocation (String address) {
		type(By.id("pickUpPlace"),address);
		pauseThreadSleep(1500);
		mouseClick(By.cssSelector("div.pac-item"));
		pauseThreadSleep(1500);
	}

	public void submitForm () {
		mouseClick(By.cssSelector("button[type='submit']"));
	}

	public void clickOkOnCarAdd () {
		mouseClick(By.xpath("//button[normalize-space()='Show car']"));
	}
}
