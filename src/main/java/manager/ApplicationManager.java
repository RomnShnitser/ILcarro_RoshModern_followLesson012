package manager;

import models.Car;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
	public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
	//===========================================================================================
	WebDriver driver;
	HelperUser user;
	HelperCar car;


	/*#########################################################################################*/
	public void initialization () {
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		//- - - - - - - - - - - - - - - - -
		driver = new ChromeDriver();
		user = new HelperUser(driver);
		car = new HelperCar(driver);

		//- - - - - - - - - - - - - - - - -
		driver.manage().window().maximize();
		driver.navigate().to("https://ilcarro.web.app/search");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}
	/*#########################################################################################*/

	// Methods
	public void stop() {
		driver.quit();
	}

	public void pauseThreadSleep (int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	//Getter
	//===========================================================================================
	public HelperUser getUser () {
		return user;
	}

	public HelperCar getCar () {
		return car;
	}
}
