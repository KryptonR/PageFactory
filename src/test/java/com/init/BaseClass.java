package com.init;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.utilities.Generics;

public class BaseClass {

	public WebDriver driver;
	Generics generics = new Generics();
	DesiredCapabilities capability = new DesiredCapabilities();

	// To get Project Directory location
	String PROJECT_DIR = System.getProperty("user.dir");

	// @Parameters({ "browser", "url" })
	@BeforeTest
	public void browserInit() { 

		capability.setJavascriptEnabled(true);

		String browser = generics.getProperty("browser");
		String URL = generics.getProperty("url");

		switch (browser.toLowerCase()) {
		case "mozilla firefox":
		case "firefox":
		case "firefox browser":
			System.setProperty("webdriver.gecko.driver",
					PROJECT_DIR + File.separator + "drivers" + File.separator + "geckodriver.exe");
			capability = DesiredCapabilities.firefox();
			driver = new FirefoxDriver(capability);
			break;
		case "internet explorer":
		case "ie":
		case "ie11":
			System.setProperty("webdriver.ie.driver",
					PROJECT_DIR + File.separator + "drivers" + File.separator + "IEDriverServer.exe");
			capability = DesiredCapabilities.internetExplorer();
			driver = new InternetExplorerDriver(capability);
			break;
		case "edge":
		case "microsoft edge":
		case "ms edge":
			System.setProperty("webdriver.edge.driver",
					PROJECT_DIR + File.separator + "drivers" + File.separator + "msedgedriver.exe");
//			EdgeOptions options = new EdgeOptions();
//			if (Boolean.parseBoolean(generics.getProperty("headless"))) {
//				options.("--headless");
//			}
//			options.addArguments("--start-maximized");
//			options.addArguments("incognito");
			capability = DesiredCapabilities.edge();
			driver = new EdgeDriver(capability);
			break;
		default:
			System.setProperty("webdriver.chrome.driver",
					PROJECT_DIR + File.separator + "drivers" + File.separator + "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (Boolean.parseBoolean(generics.getProperty("headless"))) {
				options.addArguments("--headless");
			}
			options.addArguments("--start-maximized");
			options.addArguments("incognito");
			capability = DesiredCapabilities.chrome();
			driver = new ChromeDriver(options);
			break;
		}

		System.out.println("******************** Open " + browser + " successfully.");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(generics.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		driver.get(URL);

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result, Method method) {

		Reporter.setCurrentTestResult(result);

		if (result.getStatus() == 2) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File file = screenshot.getScreenshotAs(OutputType.FILE);

			File dir = new File(PROJECT_DIR + File.separator + "screenshot");
			if (!dir.exists()) {
				dir.mkdir();
			}

			// Unique - always epoch time/unix time
			// 1st January 1970

			// 1599941773_doLogin.PNG
			// 1599941801_doLogin.PNG

			String path = dir + File.separator + System.currentTimeMillis() + "_" + method.getName() + ".PNG";
			File scrst = new File(path);
			try {
				FileUtils.copyFile(file, scrst);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			generics.log("<hr>");
			generics.log("<p style='color:Red;'> TEST IS FAILED </p><br>");
			generics.log("<img src='" + path + "' width=900 height=400/>");
			generics.log("<hr>");

		} else if (result.getStatus() == 1) {
			generics.log("<hr>");
			generics.log("<p style='color:Green;'> TEST IS PASSED </p><br>");
			generics.log("<hr>");
		}

		driver.quit();
	}

}
