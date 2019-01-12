/*
 This is out testscript. Here we call the actions required to perform
 our testcase. This is the entry point for execution our testcases.
 */

package wipro.automationassignment.testscripts;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import wipro.automationassignment.base.DriverFactory;
import wipro.automationassignment.pages.actions.BuyTvActions;
import wipro.automationassignment.pages.actions.LoginActions;
import wipro.automationassignment.pages.actions.SettingsActions;
import wipro.automationassignment.utills.AppiumUtilities;

public class BuyTvTest {
	
	private AndroidDriver<MobileElement> driver;
	private AppiumUtilities au;
	private SettingsActions settingActions;
	private LoginActions loginActions;
	private BuyTvActions buyTvActions;
	
	@Parameters({ "port"})
	@BeforeMethod
	public void setUp(String port)
			throws MalformedURLException, InvalidElementStateException, UnexpectedException {

		try {
			this.driver = new DriverFactory().getDriver(port);
			settingActions = new SettingsActions(driver);
			loginActions = new LoginActions(driver);
			buyTvActions = new BuyTvActions(driver);
			au = new AppiumUtilities(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buyTvTest() {
		
		//Do the login in to ebay App
		loginActions.login();
		
		//Change the region/country to Australia
		settingActions.changeRegion();
		
		//Perform TV buying action.
		buyTvActions.buyTv();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{   
		au.quitDriver();
	}

}



