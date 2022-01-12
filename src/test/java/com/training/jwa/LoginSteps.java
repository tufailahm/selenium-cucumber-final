package com.training.jwa;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.training.jwa.pages.LoginPage;
import com.training.jwa.pages.LoginPage_PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	public static String browser = "chrome";
	public static WebDriver driver;
	LoginPage_PageFactory loginPage_PageFactory;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  System.out.println("###User is on login page");
	  System.out.println("###Browser is open");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			loginPage_PageFactory = new LoginPage_PageFactory(driver);
		}
		driver.navigate().to("https://example.testproject.io/web/");
	  //https://example.testproject.io/web/
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		  System.out.println("###user enters username and password");
			//driver.findElement(By.id("name")).sendKeys(username);
		//	driver.findElement(By.id("password")).sendKeys(password);
		  loginPage_PageFactory.enterUsername(username);
		  loginPage_PageFactory.enterPassword(password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		  System.out.println("###clicks on login button");
			//driver.findElement(By.id("login")).click();
		  loginPage_PageFactory.clickLogin();
		  //screen shot
		  
	}

	@Then("^user is navigated to the home page that should contain (.*)$")
	public void user_is_navigated_to_the_home_page(String message) {
		  System.out.println("###user is navigated to the home page");
		  //to do 
		  //assert
		  String check= driver.findElement(By.xpath("//*[@id=\"greetings\"]")).getText();
			assertTrue(check.contains("Hello "+message+", let's complete the test form:"));
	}
	
	/*
	 * @After public void close() { driver.close(); driver.quit(); }
	 */
}
