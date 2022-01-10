package com.training.jwa;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {

	public static String browser = "chrome";
	public static WebDriver driver;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("###Browser is open");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}
	@Given("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("###user is on google search page");
		driver.navigate().to("https://www.google.com");

	}
	@When("user enters a text in the search box")
	public void user_enters_a_text_in_the_search_box() {
		System.out.println("###user enters a text in the search box");
		driver.findElement(By.name("q")).sendKeys("oneplus");

	}
	@When("hits enter")
	public void hits_enter() {
		System.out.println("###hits enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		System.out.println("###user is navigated to search results");
		//to do 
		//assert
		String checkResults = driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText();
	    assertTrue(checkResults.contains("results"));

	}

	@After
	public void done() {
		System.out.println("closing the browser");
		driver.close();
		driver.quit();
		
	}
}
