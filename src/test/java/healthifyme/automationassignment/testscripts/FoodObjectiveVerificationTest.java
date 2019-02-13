/*
 This is our testscript. Here we call the actions required to perform
 our testcase. This is the entry point for execution of our testcases.
 */

package healthifyme.automationassignment.testscripts;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import healthifyme.automationassignment.base.DriverFactory;
import healthifyme.automationassignment.config.PrepareConfigJSON;
import healthifyme.automationassignment.pages.actions.FoodItemTrackActions;
import healthifyme.automationassignment.pages.actions.LoginActions;
import healthifyme.automationassignment.utills.AppiumUtilities;

public class FoodObjectiveVerificationTest {
	
	private AndroidDriver<MobileElement> driver;
	private AppiumUtilities au;
	private LoginActions loginActions;
	private FoodItemTrackActions foodItemTrackActions;
	protected JsonObject Config = null;
	
	@Parameters({ "port"})
	@BeforeMethod
	public void setUp(String port)
			throws MalformedURLException, InvalidElementStateException, UnexpectedException {

		try {
			this.Config = PrepareConfigJSON.GetJsonObjectFromFile(
					"/src/test/java/healthifyme/automationassignment/config/", "testConfig.json");
			this.driver = new DriverFactory().getDriver(port);
			loginActions = new LoginActions(driver); 
			foodItemTrackActions = new FoodItemTrackActions(driver);
			au = new AppiumUtilities(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buyTvTest() {
		Reporter.log("Read email Id from config");
		String username = Config.get("emailId").getAsString();
		
		Reporter.log("Read password from config");
		String password = Config.get("password").getAsString();
		
		Reporter.log("calling login function with email: "+username+" and password: "+password);
		loginActions.login(username,password);
		
		Reporter.log("Read today's food objective text from config");
		String foodObjective = Config.get("foodObjectiveText").getAsString();
		
		Reporter.log("calling trackFoodObjective function with today's foodObjective: "+foodObjective);
		foodItemTrackActions.trackFoodObjective(foodObjective);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{   
		au.quitDriver();
	}

}



