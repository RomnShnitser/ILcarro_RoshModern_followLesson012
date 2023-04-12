package qa;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
	public static ApplicationManager app = new ApplicationManager();
	public Logger logger = LoggerFactory.getLogger(TestBase.class);

	@BeforeSuite
	public void setup () {
		app.initialization();
	}

	@AfterSuite
	public void tearDown () {
		app.stop();
	}


	//Logger
	@BeforeMethod
	public void startTest (Method method) {
		logger.info("TEST STARTED :: " + method.getName());
		logger.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
	}

	@AfterMethod
	public void stopTest (Method method) {
		logger.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		logger.info("TEST ENDED :: " + method.getName());
		logger.info("\n================================================================================================================================\n\n");
	}


}
