package com.tests;

import org.testng.annotations.Test;

import com.init.BaseClass;
import com.po.DashboardPO;
import com.po.LandingPO;
import com.po.LoginPO;
import com.po.LoginVerification;
import com.utilities.Generics;

public class LoginTests extends BaseClass {

	Generics generics = new Generics();

	@Test
	public void invalidLogin() {

		LandingPO landingPage = new LandingPO(driver);
		LoginPO login = new LoginPO(driver);
		LoginVerification loginVerification = new LoginVerification(driver);

		generics.log("Verify Login");

		landingPage.clickOnSignInButton();

		login.enterEmail("test@Mail.com");
		login.enterPassword("test@123");
		login.clickOnSignIn();

		loginVerification.verifyInvalidLogin();

		login.enterEmail("test2@Mail.com");
		login.enterPassword("test@123");
		login.clickOnSignIn();

		loginVerification.verifyInvalidLogin();
	}

	@Test
	public void doLogin() {

		LandingPO landingPage = new LandingPO(driver);
		LoginPO login = new LoginPO(driver);
		LoginVerification loginVerification = new LoginVerification(driver);

		generics.log("Verify Login");

		landingPage.clickOnSignInButton();

		login.enterEmail(generics.getProperty("email"));
		login.enterPassword(generics.getProperty("password"));
		login.clickOnSignIn();

		loginVerification.verifyLoginSuccess();

	}

	@Test
	public void doLogout() {
		DashboardPO dashboard = new DashboardPO(driver);
		LoginPO login = new LoginPO(driver);
		LoginVerification loginVerification = new LoginVerification(driver);

		login.loginAs(generics.getProperty("email"), generics.getProperty("password"));
		dashboard.clickOnSignOut();
		loginVerification.logoutSuccess();
	}

}
