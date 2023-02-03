package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ContextSwitchingDemo {

	AndroidDriver<AndroidElement> driver;
		
	@BeforeTest
	public void launchBrowser() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("browserName", "Chrome");
		dc.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		
		driver.get("https://www.ebay.com");
	}
	
	@Test
	public void addShortcutToHomeScreen() {
		//Default context
		Set<String> contexts = driver.getContextHandles();
		for(String t:contexts) {
			System.out.println(t);
		}
		System.out.println("Current context :"+driver.getContext());
		
		//Switch to natve app context
		driver.context("NATIVE_APP");
		
		//Click on three dots at the top right corner
		driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
		
		//Click 'Add to Home screen' in the context menu
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add to Home screen']")).click();
		
		//Wait for pop-up to appear
		WebDriverWait  wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.chrome:id/positive_button")));
		
		//Click on the Add button on the pop-up
		driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
		
		//Click on Add to Home screen button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Add to Home screen']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Add to Home screen']")).click();
		
	}
		
	@AfterTest
	public void closeApp() {
		//driver.quit();
	}

	
}
