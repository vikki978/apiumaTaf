/*
 This class create and returns the desired android driver for automation.
 getDriver method here takes port number of appium server as argument.
 
 */


package healthifyme.automationassignment.base;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DriverFactory {

	private AndroidDriver<MobileElement> driver;

	public AndroidDriver<MobileElement> getDriver(String port) {
		try {
			File app = new File("HealthifyMe-basic-release-4.apk");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			caps.setCapability("--suppress-adb-kill-server", true);
			caps.setCapability("--session-override", true);
			caps.setCapability("clearSystemFiles", true);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 620);
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + port + "/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
