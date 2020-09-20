package com.tests;

import org.testng.annotations.Test;

import com.init.BaseClass;
import com.po.LandingPO;
import com.po.LoginVerification;
import com.po.SignUpPO;
import com.po.SignUpVerification;
import com.utilities.Generics;

public class SignUpTests extends BaseClass {

	Generics generics = new Generics();

	@Test
	public void doSignUp() {

		SignUpPO signup = new SignUpPO(driver);
		LoginVerification loginVerification = new LoginVerification(driver);
		SignUpVerification signupVerification = new SignUpVerification(driver);

		generics.log("Verify user can signup successfully.");

		LandingPO landingPage = new LandingPO(driver);
		landingPage.clickOnSignInButton();

		loginVerification.verifySignUpSectinDisplay();

		signup.enterEmail();
		signup.clickOnCreateAccountButton();

		signupVerification.verifySignUpScreenDisplay();

		signup.selectGender();
		signup.enterFirstName();
		signup.enterLastName();
		signup.enterPassword();

		signup.selectDOB();
		signup.selectNewsLetter();
		signup.selectOffers();

		signup.setAddress();
		signup.setCity();

		signup.selectState();
		signup.enterZip();

		signup.enterCellNumber();
		signup.referenceAddress();

		signup.clickOnRegister();

		signupVerification.verifySignUpSuccess();

	}

}
