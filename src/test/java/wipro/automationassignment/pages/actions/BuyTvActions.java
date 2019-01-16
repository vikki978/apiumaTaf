/*
 Here we write the code for all the actions performed for buying an item
 from ebay
 */
package wipro.automationassignment.pages.actions;

import org.testng.Assert;
import org.testng.Reporter;

import com.google.gson.JsonObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import wipro.automationassignment.config.PrepareConfigJSON;
import wipro.automationassignment.pages.CheckOutPage;
import wipro.automationassignment.pages.EBayHomePage;
import wipro.automationassignment.pages.ProductSearchPage;
import wipro.automationassignment.utills.AppiumUtilities;

public class BuyTvActions implements EBayHomePage, ProductSearchPage, CheckOutPage {

	protected JsonObject Config = null;
	private AppiumUtilities au = null;

	public BuyTvActions(AndroidDriver<MobileElement> driver) {
		try {
			this.Config = PrepareConfigJSON.GetJsonObjectFromFile("/src/test/java/wipro/automationassignment/config/",
					"testConfig.json");
			au = new AppiumUtilities(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void buyTv() {

		au.tap(searchBox);
		Reporter.log("Tap on searchbox successfull");
		au.enterText(searchForAnyThing, Config.get("tvType").getAsString());
		Reporter.log("enter the iten details in searchbox successfully");
		au.pressKeyboardEnter();
		au.findElement(itme).get(1).click();
		Reporter.log("Tap on the item on search screen successfull");
		String itemNameOnSearchScreen = au.findElement(itemName1).get(0).getText();
		Reporter.log("get the item name in a variable on search screen");
		String itemPriceOnSearchScreen = au.findElement(itemPrice1).get(0).getText();
		Reporter.log("get the item price in a variable on search screen");
		itemPriceOnSearchScreen = itemPriceOnSearchScreen.replace(" ", "").replace(",", "").replace(".00", "");
		au.tap(buyNowButton);
		Reporter.log("Tap on buy now button successfull");
		au.tap(reviewButton);
		Reporter.log("Tap on review button successfull");
		String itemNameOnCheckOutScreen = au.findElement(itemName).get(0).getText();
		Reporter.log("get the item name in a variable on checkout screen");
		String itemPriceOnCheckOutSearchScreen = au.findElement(itemPrice).get(0).getText();
		Reporter.log("get the item price in a variable on checkout screen");
		itemPriceOnCheckOutSearchScreen = itemPriceOnCheckOutSearchScreen.replace(" ", "").replace(",", "")
				.replace(".00", "");
		Assert.assertEquals(itemNameOnSearchScreen, itemNameOnCheckOutScreen);
		Assert.assertTrue(itemPriceOnSearchScreen.contains(itemPriceOnCheckOutSearchScreen.split("\\$")[1]));
		Reporter.log("successfully asserted details between search screen and checkout screen");
	}

}
