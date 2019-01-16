/*
 Here we write the code for all the actions performed for doing login
 in to ebay app
 */

package wipro.automationassignment.pages.actions;

import org.testng.Assert;
import org.testng.Reporter;

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
    /*
     * perform the login action in ebay app
     */
	public void login() {
		Reporter.log("waiting for the app to load");
		au.waitForElement(hamBurgerMenu);
		au.tap(hamBurgerMenu);
		Reporter.log("tap on hamburger menu to open menu items successfull");
		au.tap(signIn);
		Reporter.log("tap on signIn menu to open logIn screen successfull");
		au.enterText(emailId, Config.get("emailId").getAsString());
		Reporter.log("entered email ID successfully");
		au.enterText(password, Config.get("password").getAsString());
		Reporter.log("entered password successfully");
		au.tap(signInButton);
		Reporter.log("Tapped on signIn button successfully");
		if (au.findElement(fingerPrintDialog).size() > 0) {
			au.tap(mayBelaterButton);
		}
		else if (au.findElement(fingerPrintDialog1).size() > 0) {
			au.tap(mayBelaterButton1);
		}
		Assert.assertTrue(au.isVisible(hamBurgerMenu));
		Reporter.log("LogIn is successfull");
	}

}
