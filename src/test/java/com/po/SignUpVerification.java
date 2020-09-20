package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.Generics;

public class SignUpVerification {

	WebDriver driver;
	Generics generics = new Generics();

	public SignUpVerification(WebDriver driver) {
		this.driver = driver;
		// initialize Page Factory
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "customer_firstname")
	public WebElement textFirstName;

	@FindBy(id = "customer_lastname")
	public WebElement textLastName;

	@FindBy(className = "logout")
	public WebElement logoutButton;

	public void verifySignUpScreenDisplay() {
		generics.log("Verify Signup Screen display.");
		Assert.assertTrue(generics.isElementDisplay(textFirstName));
		Assert.assertTrue(generics.isElementDisplay(textLastName));
	}

	public void verifySignUpSuccess() {
		generics.log("Verify SignUp Successful");
		Assert.assertTrue(generics.isElementDisplay(logoutButton));
	}
}
