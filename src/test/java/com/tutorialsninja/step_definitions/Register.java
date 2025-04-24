package com.tutorialsninja.step_definitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.DriverFactory.DriverFactory_Logic;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {

	public WebDriver driver;

	@Given("User navigates to RegisterPage")
	public void user_navigates_to_registerPage() {
		driver = DriverFactory_Logic.getDriver();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#content>h1")).isDisplayed());
	}
	
	@When("User enters below fields")
	public void user_enters_details(DataTable datatable) {
		Map<String, String> dataMap = datatable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(emailWithDateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));	
	}

	@And("User enters firstname as {string}")
	public void user_enters_firstname(String firstnametext) {
		driver.findElement(By.id("input-firstname")).sendKeys(firstnametext);
	}

	@And("User enters lastname as {string}")
	public void user_enters_lastname(String lastnametext) {
		driver.findElement(By.id("input-lastname")).sendKeys(lastnametext);
	}
	
	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timestamp + "@gmail.com";
	}
	
	@And("User enters email as {string}")
	public void user_enters_email(String emailtext) {
		if(emailtext.equals("Random Email")) {
			driver.findElement(By.id("input-email")).sendKeys(emailWithDateTimeStamp());
		}else {
			System.out.println("Ignore");
		}	
	}

	@And("User enters telephone as {string}")
	public void user_enters_telephone(String telephonetext) {
		driver.findElement(By.id("input-telephone")).sendKeys(telephonetext);
	}

	@And("User enters password as {string}")
	public void user_enters_password(String passwordtext) {
		driver.findElement(By.id("input-password")).sendKeys(passwordtext);
	}
	
	@And("User enters confirmpassword as {string}")
	public void user_enters_confirmpassword(String confirmpasswordtext) {
		driver.findElement(By.id("input-confirm")).sendKeys(confirmpasswordtext);
	}
	
	@And("User selects the Yes radiobutton")
	public void user_selects_yes() {
		driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();
	}
	
	@And("User checks the PrivacyPolicy checkbox")
	public void user_checks_privacypolicy() {
		driver.findElement(By.xpath("//input[@name = 'agree' and @value = '1']")).click();
	}
	
	
	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() throws Exception {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	}
	
	
	@Then("User is navigated to AccountSuccessPage")
	public void user_is_navigated_to_accountsuccesspage() {
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]")).isDisplayed());
	}
	
	@And("User enters email {string} as duplicate email")
	public void user_enters_Duplicate_email(String duplicateemailtext) {
		driver.findElement(By.id("input-email")).sendKeys(duplicateemailtext);
	}
	
	@Then("User gets warning message about duplicate email")
	public void user_gets_duplicate_email_warning() {
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, ' alert-dismissible')]")).getText();
		 String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		 Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	@Then("User gets warning message about password confirmation")
	public void user_gets_warning_about_incorrect_confirmpassword() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Password confirmation does not match password!')]")).isDisplayed());
	}

}
