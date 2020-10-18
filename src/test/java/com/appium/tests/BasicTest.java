package com.appium.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasicTest {

	public static void main(String[] args) throws MalformedURLException {

		File f = new File("src\\Lib");
		File apk = new File(f, "amazon_shopping.apk");
		System.out.println("APK path: " + apk);

		DesiredCapabilities dCap = new DesiredCapabilities();
		dCap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM J710F");
		dCap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
		dCap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		dCap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1.4723/wd/hub"), dCap);
		
	
	}

}
