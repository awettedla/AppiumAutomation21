package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class CalculatorTest {

    @Before
    public void setup() throws MalformedURLException {
        //list of all capabilities: http://appium.io/docs/en/writing-running-appium/caps/index.html
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //which framework to use for automation
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //platform of device under test
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //specify android version
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        //specify device name
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        //app or appActivity and appPackage name
        // option 1: new apps
        // option 2: preinstalled apps, e.g. calculator
        //appActivity - path to the Main class that runs program (com.google.calculator.Main)
        //appPackage - path that leads to the main class (com.google.calculator)
        //these are the capabilities for Calculator app
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        //appium driver --> appium server --> device
        //specify address of appium server
        //if appium server runs on the same computer, address is always localhost
        //sometimes, you will see 0.0.0.0 or 127.0.0.1 instead of localhost
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
        //WebDriver --> RemoteWebDriver --> DefaultGenericMobileDriver --> AppiumDriver --> AndroidDriver
        //Question: what's the relationship between ChromeDriver and AppiumDriver?
        //- they are cousins. both of them are children of WebDriver.

    }
}
