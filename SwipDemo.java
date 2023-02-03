package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwipDemo {
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("appPackage", "com.google.android.apps.maps");
		dc.setCapability("appActivity", "com.google.android.maps.MainActivity");
		dc.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
	}
	
	@Test
	public void swipeFromLeftToRight() {
		
		//TouchAction ta = new TouchAction(driver);
	}

}
