package com.smartsense;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utill.Constant;
import Utill.ExcelUtils;
import Utill.Log;

public class TestNG_Framework {

	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		Log.logSetup();
		Log.startTestCase("Selenium_Test_001");
		ExcelUtils.setExcelFile(Constant.FILE_FULL_PATH, "Sheet1");
		Log.info(" Excel sheet opened");
		driver = new ChromeDriver();
		Log.info("New driver instantiated");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.get("http://taxinearu.co.uk");
	}

	@Test
	public void main() throws Exception {
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Log.info("Click action is perfomred on Log Out link");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}