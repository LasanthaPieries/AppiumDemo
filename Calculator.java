package com.simplilearn.AppiumDemo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calculator {

	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName" , "ANDROID");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		cap.setCapability("app", "C:\\Users\\Admin\\Desktop\\apk files\\com.miui.calculators.apk");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
	}
	
	@Test(priority=0)
	public void verifyAdditionProcess() {
		//Press digit 9
		driver.findElement(By.id("com.miui.calculator:id/digit_9")).click();
		
		//Press + symbol
		driver.findElementByAccessibilityId("plus").click();
		
		//Press digit 6
		driver.findElement(By.id("com.miui.calculator:id/digit_6")).click();
		
		//Press = button
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();
		
		String expectedResult = "15";
		String actualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);
		Assert.assertEquals(actualResult, expectedResult);
	}
		
	@Test(priority=1)
	public void verifyMultiplicationProcess() {
		// Press digit 5
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();
		
		//Press * symbol
		driver.findElement(By.id("com.miui.calculator:id/op_mul")).click();
		
		//Press digit 4
		driver.findElement(By.id("com.miui.calculator:id/digit_4")).click();
		
		//Press = button
		driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
		
		String expectedResult = "20";
		String acctualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);
		Assert.assertEquals(acctualResult, expectedResult);
	}
	
	@Test(priority=2)
	public void verifyDelButnPresent() {
		boolean clearButtonDisplayed = driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).isDisplayed();
		Assert.assertTrue(clearButtonDisplayed);
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}

}
