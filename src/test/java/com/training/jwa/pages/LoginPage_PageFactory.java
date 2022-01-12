package com.training.jwa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * simple and easier implemntation of POM in selenium
 * 
 */
public class LoginPage_PageFactory {

	WebDriver driver;

	@FindBy(id = "name")
	WebElement txt_username;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "login")
	WebElement btn_login;

	@FindBy(id = "logout")
	WebElement btn_logout;

	public LoginPage_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogin() {
		btn_login.click();
	}

	public boolean checkLogoutDisplayed() {
		return btn_logout.isDisplayed();
	}

}
