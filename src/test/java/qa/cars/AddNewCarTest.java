package qa.cars;

import models.Car;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class AddNewCarTest extends TestBase {
	@BeforeMethod
	public void precondition () {
		if(!app.getUser().isLogged()) {
			app.getUser().login(new User()
					.withEmail("asd@fgh.com")
					.withPassword("$Asdf1234")
			);
		}
	}

	@Test
	public void addNewCarPositiveTest () {
		int a = (int) (System.currentTimeMillis() / 1000) % 3600;

		Car car = Car.builder()
				.address("Tel Aviv")
				.make("KIA")
				.model("Sportage")
				.year("2020")
				.fuel("Petrol")
				.seats("4")
				.carClass("5")
				.carRegNumber("100-200-" + a)
				.price("150")
				.build();
		app.pauseThreadSleep(1000);
		app.getCar().openCarForm();
		app.pauseThreadSleep(1000);
		app.getCar().fillCarForm(car);
		app.getCar().submitForm();
		app.pauseThreadSleep(1000);
		app.getCar().clickOkOnCarAdd();
		logger.info("New car added: " + car.toString());
	}

	@AfterMethod
	public void postCondition () {
		app.pauseThreadSleep(2000);
		app.getUser().goHome();

	}
}
