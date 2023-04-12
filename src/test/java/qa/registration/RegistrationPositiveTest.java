package qa.registration;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class RegistrationPositiveTest extends TestBase {
	@BeforeMethod
	public void precondition () {
		if(app.getUser().isLogged()){
			app.getUser().logout();
		}
	}

	@Test
	public void registrationPositiveTest () {
		int a = (int) (System.currentTimeMillis() / 1000) % 3600;
		User user = new User()
				.withName("John")
				.withLastName("Doe")
				.withEmail("joe" + a + "@gmail.com")
				.withPassword("@Adcd1234");
		app.getUser().openRegistrationForm();
		app.getUser().openRegistrationForm();
		app.getUser().fillRegistrationForm(user);
		app.pauseThreadSleep(1500);
		app.getUser().submitRegistrationForm();
		app.pauseThreadSleep(1500);
		Assert.assertTrue(app.getUser().isRegistered());
		app.getUser().closeRegistration();
	}

	@AfterMethod
	public void postCondition () {
		app.getUser().goHome();
	}
}
