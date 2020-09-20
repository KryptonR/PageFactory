package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Generics;

public class LoginPO {

	WebDriver driver;
	Generics generics = new Generics();

	public LoginPO(WebDriver driver) {
		this.driver = driver;
		// initialize Page Factory
		PageFactory.initElements(driver, this);
	}

	// Page Objects
//	public By emailtext = By.id("email");
//	public By passwordText = By.id("passwd");
//	public By logiButton = By.id("SubmitLogin");
//	public By invalidPasswordMessage = By.xpath("//div[contains(@class,'alert')]//li");

	// Page Factory
	@FindBy(id = "email")
	public WebElement emailtext;

	@FindBy(id = "passwd")
	public WebElement passwordText;

	@FindBy(id = "SubmitLogin")
	public WebElement logiButton;

	@FindBy(xpath = "//div[contains(@class,'alert')]//li")
	public WebElement invalidPasswordMessage;

	public void enterEmail(String email) {
		generics.type(emailtext, email);
		generics.log("Enter Email " + email);

	}

	public void enterPassword(String password) {
		generics.type(passwordText, password);
		generics.log("Enter Password");
	}

	public void clickOnSignIn() {
		generics.clickOn(logiButton);
		generics.log("Click on Login button.");
	}

	public void loginAs(String email, String password) {

		LandingPO landingPage = new LandingPO(driver);
		landingPage.clickOnSignInButton();

		enterEmail(email);
		enterPassword(password);
		clickOnSignIn();

	}

}