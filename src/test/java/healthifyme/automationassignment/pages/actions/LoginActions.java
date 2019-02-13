/*
 Here we write the code for all the actions performed for doing login
 in to our app
 */

package healthifyme.automationassignment.pages.actions;

import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import healthifyme.automationassignment.pages.HomePage;
import healthifyme.automationassignment.pages.LoginPage;
import healthifyme.automationassignment.utills.AppiumUtilities;

public class LoginActions implements LoginPage, HomePage {

	private AppiumUtilities au = null;

	public LoginActions(AndroidDriver<MobileElement> driver) {
		try {
			au = new AppiumUtilities(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * perform the login action in HealthifyMe app
	 */
	public void login(String userName, String password) {
		boolean googleAccountDialog = false;
		Reporter.log("waiting for the app to load");
		au.waitForElement(loginButtonOnSignUpPage);
		au.tap(loginButtonOnSignUpPage);
		au.enterText(userNameTextBox, userName);
		Reporter.log("entered email ID successfully");
		au.enterText(passwordTextBox, password);
		Reporter.log("entered password successfully");
		au.tap(loginButtonOnLoginPage);
		Reporter.log("Tapped on logIn button successfully");

		Reporter.log("looking for google account selection dialog");
		if (au.findElement(googleAccountSelection).size() > 0) {
			googleAccountDialog = true;
			au.tap(googleAccountEmail);
			au.tap(googleAccountSelectionOkBtn);
			if (au.findElement(googleAccountAllow).size() > 0)
				au.tap(googleAccountAllow);
		}
		if (googleAccountDialog)
			Reporter.log("google account selection dialog handled successfully");
		else
			Reporter.log("No google account selection dialog appeared");

		Assert.assertTrue(au.isVisible(dashbord));
		Reporter.log("LogIn is successfull");
	}

}
