package com.appium.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasicTest {

	public static void main(String[] args) throws MalformedURLException {

		File f = new File("src\\Lib");
		File apk = new File(f, "amazon_shopping.apk");
		System.out.println("APK Path: " + apk);

		// Basic Configuration
		DesiredCapabilities dCap = new DesiredCapabilities();
		dCap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM J710F");
		dCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		dCap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), dCap);

		// To Vertical scroll
		int screenWidth = driver.manage().window().getSize().getWidth();
		int screenHeight = driver.manage().window().getSize().getHeight();
		System.out.println("Screen Size = " + screenWidth + " > Screen Height = " + screenHeight);
		TouchAction action = new TouchAction(driver);
		int xCoordinate = screenWidth / 2;
		int yCoordinate = (screenHeight * 7) / 10;
		int noOfPixelsToScroll = (screenHeight * 2) / 10;
		action.press(PointOption.point(xCoordinate, yCoordinate))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(xCoordinate, (yCoordinate - noOfPixelsToScroll))).release().perform();

	}

}
