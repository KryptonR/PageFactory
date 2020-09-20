package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.Generics;

public class LoginVerification implements Validations {

	WebDriver driver;
	Generics generics = new Generics();

	public LoginVerification(WebDriver driver) {
		this.driver = driver;
		// initialize Page Factory
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'alert')]//li")
	public WebElement invalidPasswordMessage;

	@FindBy(xpath = "//div[@class='header_user_info']//span")
	public WebElement username;

	@FindBy(xpath = "//a[@class='login']")
	public WebElement signInButton;

	@FindBy(id = "email_create")
	public WebElement signUpEmailText;

	@FindBy(id = "SubmitCreate")
	public WebElement createAccountButton;

	public void verifyInvalidLogin() {
		generics.log("Verify validation message display properly");
		Assert.assertEquals(generics.getText(invalidPasswordMessage), AUTHENTICATION_FAILED);

		// Instead of Assertion, which can terminate your test midway, use boolean to
		// continue your test ahead.
//		if (generics.getText(invalidPasswordMessage).equals(AUTHENTICATION_FAILED)) {
//			generics.log("<p style='color:Green;'> STEP IS PASSED </p><br>");
//		} else {
//			generics.log("<p style='color:Red;'> STEP IS FAILED </p><br>");
//		}
	}

	public void verifyLoginSuccess() {
		generics.log("Verify Login Successful");
		Assert.assertEquals(generics.getText(username), USERNAME);
	}

	public void logoutSuccess() {
		generics.log("verify user logged out");
		Assert.assertTrue(generics.isElementDisplay(signInButton));
	}

	public void verifySignUpSectinDisplay() {
		generics.log("Verify Signup Section display.");
		Assert.assertTrue(generics.isElementDisplay(signUpEmailText));
		Assert.assertTrue(generics.isElementDisplay(createAccountButton));
	}

}
