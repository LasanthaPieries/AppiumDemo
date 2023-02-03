package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SpinnerDemo {
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("appPackage", "com.touchboarder.android.api.demos");
		dc.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		dc.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
	}
	
	@Test
	public void selectColorAndDateFromSpinner() {
		//Click on API Demos
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		
		//Click on views
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		//Click on a Spinner
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();
	
		//Select yellow from the first dropdown
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='yellow']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='yellow']")).click();
		
		//Select Earth from the second dropdown
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner2")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Earth']")));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Earth']")).click();

	}
	
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
	
}
