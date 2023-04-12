package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ListenLog implements WebDriverEventListener {

	Logger logger = LoggerFactory.getLogger(ListenLog.class);

	public  ListenLog () {
		super();
	}



	@Override
	public void beforeFindBy (By by, WebElement element, WebDriver driver) {
		logger.info("Start Searching element :: " + by);
	}

	@Override
	public void afterFindBy (By by, WebElement element, WebDriver driver) {
		logger.info("End : The Element with current locator - FOUND");
	}

	@Override
	public void onException (Throwable throwable, WebDriver driver) {
		logger.info("ERROR! SOMETHING WENT WRONG!!!\n\n");
		logger.info(" = throwable.getMessage():\n" + throwable.getMessage()+"\n\n");
	}
}
