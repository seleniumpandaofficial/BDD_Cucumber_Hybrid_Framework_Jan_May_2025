package com.tutorialsninja.Hooks;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.tutorialsninja.DriverFactory.DriverFactory_Logic;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import qa.tutorialsninja.utilities.ConfigReader;
import qa.tutorialsninja.utilities.Utils;

public class MyHooks {

	public WebDriver driver;
	public Properties prop;

	@Before
	public void setup() throws Exception {
		
		prop = ConfigReader.initializePropertiesFile();
		DriverFactory_Logic.initializeBrowser(prop.getProperty("browser"));
		driver = DriverFactory_Logic.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGELOADTIMEOUT_WAIT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utils.SCRIPTTIMEOUT_WAIT));
		driver.get(prop.getProperty("url")); //this navigates to HomePage

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
