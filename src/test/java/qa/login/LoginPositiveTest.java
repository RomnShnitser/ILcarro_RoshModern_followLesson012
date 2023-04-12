package qa.login;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class LoginPositiveTest extends TestBase {
	@BeforeMethod
	public void precondition () {
		if(app.getUser().isLogged()){
			app.getUser().logout();
		}
	}

	@Test
	public void loginTest () {
		app.getUser().openLoginForm();
		String email = "asd@fgh.com";
		String password = "$Asdf1234";
		app.getUser().fillLoginForm(email,password);
		app.getUser().submitLogin();
		app.pauseThreadSleep(1500);
		app.getUser().clickOkButtonOnLogin();
		logger.info("Test: Registration Success with email: " + email + " & password: " + password);
	}

	@Test
	public void loginModelTest() {
		User userData = new User().withEmail("asd@fgh.com").withPassword("$Asdf1234");
		app.getUser().openLoginForm();
		app.getUser().fillLoginForm(userData);
		app.getUser().submitLogin();
		app.pauseThreadSleep(1500);
		Assert.assertTrue(app.getUser().isLoggedSuccess());
		app.getUser().clickOkButtonOnLogin();
		logger.info("Test: Registration Success with email: " + userData.getEmail() + " & password: " + userData.getPassword());
	}

	@AfterMethod
	public void postCondition () {
		app.pauseThreadSleep(1000);
		if(app.getUser().isLogged()){
			app.getUser().logout();
		}
		app.getUser().goHome();
	}
}
