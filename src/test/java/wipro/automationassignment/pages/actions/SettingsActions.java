/*
 Here we write the code for all the actions performed for changing the
 your country/region
 */

package wipro.automationassignment.pages.actions;

import org.testng.Assert;
import org.testng.Reporter;

import com.google.gson.JsonObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import wipro.automationassignment.config.PrepareConfigJSON;
import wipro.automationassignment.pages.EBaySettingsPage;
import wipro.automationassignment.utills.AppiumUtilities;

public class SettingsActions
		implements EBaySettingsPage {

	protected JsonObject Config = null;
	private AppiumUtilities au = null;

	public SettingsActions(AndroidDriver<MobileElement> driver) {
		try {
			this.Config = PrepareConfigJSON.GetJsonObjectFromFile("/src/test/java/wipro/automationassignment/config/", "testConfig.json");
			au = new AppiumUtilities(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Change the current autoselected region to Australia
	 */
	public void changeRegion() {
		Reporter.log("waiting for the app to load");
		au.waitForElement(hamBurgerMenu);
		au.tap(hamBurgerMenu);
		Reporter.log("tap on hamburger menu to open menu items successfull");
		au.tap(settings);
		Reporter.log("tap on settings menu to open setting screen successfull");
		au.tap(country);
		Reporter.log("tap on country/region option successfull");
		au.tap(autoDetect);
		Reporter.log("turn off auto detct region settings successfull");
		au.findElement(selectCountry).get(1).click();
		Reporter.log("tap on country/region option successfull");
		au.enterText(searchCountry, Config.get("country").getAsString());
		Reporter.log("enter the "+Config.get("country").getAsString()+" as country successfull");
		au.tap(selectCountryFromList);
		Reporter.log("Selected "+Config.get("country").getAsString()+" as country from list successfull");
		au.goBack();
		au.goBack();
		Assert.assertTrue(au.isVisible(hamBurgerMenu));
		Reporter.log("Change of current region is successfull");
	}


}
