/*
 Here we write the code for all the actions performed for changing the
 your country/region
 */

package wipro.automationassignment.pages.actions;

import org.testng.Assert;

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

	public void changeRegion() {
		
		au.waitForElement(hamBurgerMenu);
		au.tap(hamBurgerMenu);
		au.tap(settings);
		au.tap(country);
		au.tap(autoDetect);
		au.findElement(selectCountry).get(1).click();
		au.enterText(searchCountry, Config.get("country").getAsString());
		au.tap(selectCountryFromList);
		au.goBack();
		au.goBack();
		Assert.assertTrue(au.isVisible(hamBurgerMenu));
	}


}
