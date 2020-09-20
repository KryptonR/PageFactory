package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Generics;

public class LandingPO {

	WebDriver driver;
	Generics generics = new Generics();

	public LandingPO(WebDriver driver) {
		this.driver = driver;
		// initialize Page Factory
		PageFactory.initElements(driver, this);
	}

	// Page Objects
	// public By signInButton = By.xpath("//a[@class='login']");

	@FindBy(xpath = "//a[@class='login']")
	public WebElement signInButton;

	public void clickOnSignInButton() {
		generics.clickOn(signInButton);
		generics.log("Click on Sign in button.");
	}

}
