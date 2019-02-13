/*
 Here we store element locators for Login flow
 */

package healthifyme.automationassignment.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public interface LoginPage {
	
	By loginButtonOnSignUpPage = MobileBy.id("com.healthifyme.basic:id/btn_login");
	By userNameTextBox = MobileBy.id("com.healthifyme.basic:id/et_username");
	By passwordTextBox = MobileBy.id("com.healthifyme.basic:id/et_password");
	By loginButtonOnLoginPage = MobileBy.id("com.healthifyme.basic:id/btn_login_signup");
	
	By googleAccountSelection = MobileBy.xpath("//android.widget.TextView[@text='Choose an account']");
	By googleAccountSelectionOkBtn = MobileBy.xpath("//android.widget.Button[@text='OK']");
	By googleAccountEmail = MobileBy.id("android:id/text1");
	By googleAccountAllow =MobileBy.id("com.google.android.gms:id/accept_button");
	
	
	
	

}