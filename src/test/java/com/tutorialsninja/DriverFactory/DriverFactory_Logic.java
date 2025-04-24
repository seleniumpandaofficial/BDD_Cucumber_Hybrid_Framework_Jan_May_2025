package com.tutorialsninja.DriverFactory;

import java.util.Arrays;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory_Logic {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	
	  public static void initializeBrowser(String browserName){
	        if(browserName.equals("chrome")){
	            options = new ChromeOptions();
	            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	            options.addArguments("--start-maximized");
	            options.addArguments("--incognito");
	            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
	            driver = new ChromeDriver(options);
	        }else if(browserName.equals("Firefox")){
	            driver = new FirefoxDriver();
	            driver.manage().window().maximize();
	        }else if(browserName.equals("Edge")){
	            driver = new EdgeDriver();
	            driver.manage().window().maximize();
	        }else {
	            System.out.println("Browser Does Not Exist");
	        }
	         
	    }
	  
	  
	  public static WebDriver getDriver() {
		  return driver;
	  }

}
