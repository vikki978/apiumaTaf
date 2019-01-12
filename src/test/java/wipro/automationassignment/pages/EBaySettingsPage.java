/*
 Here we store element locators for Settings Page
 */

package wipro.automationassignment.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public interface EBaySettingsPage {
	
	By hamBurgerMenu = By.id("home");
	By settings = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Settings\").instance(0))");
	By country = By.xpath("//*[@text='Country/region']");
	By autoDetect = By.id("switch_widget");	
	By selectCountry = By.xpath("//*[@text='Country/region']");	
	By searchCountry = By.id("filter");
	By selectCountryFromList = By.id("check_country");

}
