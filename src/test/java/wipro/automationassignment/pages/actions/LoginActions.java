/*
 Here we write the code for all the actions performed for doing login
 in to ebay app
 */

package wipro.automationassignment.pages.actions;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import wipro.automationassignment.config.PrepareConfigJSON;
import wipro.automationassignment.pages.EBaySettingsPage;
import wipro.automationassignment.pages.LoginPage;
import wipro.automationassignment.utills.AppiumUtilities;

public class LoginActions implements EBaySettingsPage, LoginPage {

	protected JsonObject Config = null;
	private AppiumUtilities au = null;

	public LoginActions(AndroidDriver<MobileElement> driver) {
		try {
			this.Config = PrepareConfigJSON.GetJsonObjectFromFile("/src/test/java/wipro/automationassignment/config/",
					"testConfig.json");
			au = new AppiumUtilities(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void login() {

		au.waitForElement(hamBurgerMenu);
		au.tap(hamBurgerMenu);
		au.tap(signIn);
		au.enterText(emailId, Config.get("emailId").getAsString());
		au.enterText(password, Config.get("password").getAsString());
		au.tap(signInButton);
		if (au.findElement(fingerPrintDialog).size() > 0) {
			au.tap(mayBelaterButton);
		}
		Assert.assertTrue(au.isVisible(hamBurgerMenu));
	}

}
