package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Generics;

public class DashboardPO {

	WebDriver driver;
	Generics generics = new Generics();

	public DashboardPO(WebDriver driver) {
		this.driver = driver;
		// initialize Page Factory
		PageFactory.initElements(driver, this);
	}

	// Page Objects
//	public By username = By.xpath("//div[@class='header_user_info']//span");
//	public By logoutButton = By.className("logout");

	@FindBy(className = "logout")
	public WebElement logoutButton;

	public void clickOnSignOut() {
		generics.clickOn(logoutButton);
		generics.log("Click on Sing Out button.");
	}

}
