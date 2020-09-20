package com.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Generics;

public class SignUpPO {

	WebDriver driver;
	Generics generics = new Generics();

	String address1 = "BELT LINE ROAD";
	String city = "ADDISON";
	String addressRef = "SUITE 150";

	public SignUpPO(WebDriver driver) {
		this.driver = driver;
		// initialize Page Factory
		PageFactory.initElements(driver, this);
	}

	/*
	 * @FindBy - Find Single Element by single locator
	 * 
	 * @FindBys - Find Single Element by multiple locators
	 * 
	 * @FindAll - Find Multiple Elements by Single locator
	 * 
	 */

	@FindBy(id = "email_create")
	public WebElement signUpEmailText;

	@FindBy(id = "SubmitCreate")
	public WebElement createAccountButton;

	@FindBy(id = "customer_firstname")
	public WebElement textFirstName;

	@FindBy(id = "customer_lastname")
	public WebElement textLastName;

	@FindBy(id = "passwd")
	public WebElement passwordText;

	@FindAll(value = { @FindBy(xpath = "//label[contains(@for,'id_gender')]") })
	public List<WebElement> listOfGenders;

	@FindBy(id = "days")
	public WebElement selectDays;

	@FindAll(value = { @FindBy(xpath = "//select[@id='days']//option") })
	public List<WebElement> listOfDays;

	@FindBy(id = "months")
	public WebElement selectMonths;

	@FindAll(value = { @FindBy(xpath = "//select[@id='months']//option") })
	public List<WebElement> listOfMonths;

	@FindBy(id = "years")
	public WebElement selectYears;

	@FindAll(value = { @FindBy(xpath = "//select[@id='years']//option") })
	public List<WebElement> listOfYears;

	@FindBy(id = "newsletter")
	public WebElement newsletterCheck;

	@FindBy(id = "optin")
	public WebElement offersCheck;

	@FindBy(id = "address1")
	public WebElement address1Text;

	@FindBy(id = "city")
	public WebElement cityText;

	@FindBy(id = "id_state")
	public WebElement selectState;

	@FindAll(value = { @FindBy(xpath = "//select[@id='id_state']//option") })
	public List<WebElement> listOfStates;

	@FindBy(id = "postcode")
	public WebElement zipText;

	@FindBy(id = "phone_mobile")
	public WebElement mobileText;

	@FindBy(id = "alias")
	public WebElement referenceAddressText;

	@FindBy(id = "submitAccount")
	public WebElement buttonRegister;

	public void enterEmail() {
		String email = generics.getRandomEmail(); // autotest54808@testmail.com
		generics.type(signUpEmailText, email);
		generics.log("Enter Email " + email);
	}

	public void clickOnCreateAccountButton() {
		generics.clickOn(createAccountButton);
		generics.log("Click on Create Account Button button.");
	}

	public void selectGender() {
		WebElement gender = listOfGenders.get(generics.randomNumber(listOfGenders));
		generics.clickOn(gender);
		generics.log("Click on Gender : " + generics.getText(gender));
	}

	public void enterFirstName() {
		generics.type(textFirstName, "Johan");
		generics.log("Enter First Name " + "Johan");
	}

	public void enterLastName() {
		generics.type(textLastName, "Morgan");
		generics.log("Enter Last Name " + "Morgan");
	}

	public void enterPassword() {
		generics.type(passwordText, "Test@1234");
		generics.log("Enter Password " + "Test@1234");
	}

	public void selectDOB() {
		// Day
		generics.selectValueBy(selectDays, listOfDays);

		// Month
		generics.selectValueBy(selectMonths, listOfMonths);

		// Year
		generics.selectValueBy(selectYears, listOfYears);

	}

	public void selectNewsLetter() {
		if (generics.getRandomBoolean()) {
			generics.clickOn(newsletterCheck);
			generics.log("Check 'Sign up for our newsletter!'.");
		}
	}

	public void selectOffers() {
		if (generics.getRandomBoolean()) {
			generics.clickOn(offersCheck);
			generics.log("Check 'Receive special offers from our partners!'.");
		}
	}

	public void setAddress() {
		generics.type(address1Text, address1);
		generics.log("Enter Address 1 " + address1);
	}

	public void setCity() {
		generics.type(cityText, city);
		generics.log("Enter City " + city);
	}

	public void selectState() {
		generics.selectValueBy(selectState, listOfStates);
	}

	public void enterZip() {
		int zip = generics.randomNumber();
		generics.type(zipText, zip + "");
		generics.log("Enter ZIP " + zip);
	}

	public void enterCellNumber() {
		String cellNum = generics.randomNumber() + "" + generics.randomNumber(); // 10101 + 20000 > 30101
		generics.type(mobileText, cellNum);
		generics.log("Enter Phone Number " + cellNum);

	}

	public void referenceAddress() {
		generics.type(referenceAddressText, addressRef);
		generics.log("Enter Address " + addressRef);
	}

	public void clickOnRegister() {
		generics.clickOn(buttonRegister);
		generics.log("Click on Register Button button.");
	}

}
