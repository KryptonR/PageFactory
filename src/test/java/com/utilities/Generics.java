package com.utilities;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Generics {

	// To get Project Directory location
	String PROJECT_DIR = System.getProperty("user.dir");

	public int randomNumber(List<WebElement> list) {
		Random r = new Random();
		int start = 0;
		int end = list.size();
		return r.nextInt(end - start) + start;
	}

	public int randomNumber() {
		Random r = new Random();
		int start = 10000;
		int end = 99999;
		return r.nextInt(end - start) + start;
	}

	public void pause(int second) {
		try {
			Thread.sleep(second * 1000); // millisecond -> sec * 1000
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void log(String s) {
		System.out.println(s);
		Reporter.log(s + "<br>");
	}

	public void type(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public WebElement getElement(WebDriver driver, By by) {
		return driver.findElement(by);
	}

	public String getText(WebElement element) {
		log(element.getText());
		return element.getText();
	}

	public boolean isElementDisplay(WebElement element) {
		return element.isDisplayed();
	}

	public String getProperty(String key) {

		Properties prop = new Properties();
		String value = "";

		try {

			FileReader properties = new FileReader(PROJECT_DIR + File.separator + "config.properties");
			prop.load(properties);
			value = prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;

	}

	public String getRandomEmail() {
		return "autotest" + randomNumber() + "@testmail.com";
	}

	public boolean getRandomBoolean() {
		// 11101 % 2 => 1 (remainder)
		// 86572 % 2 => 0
		// If number is even return true else return false
		return randomNumber() % 2 == 0;
	}

	public void selectValueBy(WebElement selectTag, List<WebElement> optionsTag) {
		Select days = new Select(selectTag);
		days.selectByIndex(randomNumber(optionsTag));
	}

}
