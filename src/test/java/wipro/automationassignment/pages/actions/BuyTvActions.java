/*
 Here we write the code for all the actions performed for buying an item
 from ebay
 */
package wipro.automationassignment.pages.actions;

import org.testng.Assert;

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
		au.enterText(searchForAnyThing, Config.get("tvType").getAsString());
		au.pressKeyboardEnter();
		au.findElement(itme).get(1).click();
		
		//Store item name and price details on search screen
		String itemNameOnSearchScreen = au.findElement(itemName1).get(0).getText();
		String itemPriceOnSearchScreen = au.findElement(itemPrice1).get(0).getText();
		itemPriceOnSearchScreen = itemPriceOnSearchScreen.replace(" ", "").replace(",", "").replace(".00", "");
		au.tap(buyNowButton);
		au.tap(reviewButton);
		
		//Store item name and price details on checkout screen
		String itemNameOnCheckOutScreen = au.findElement(itemName).get(0).getText();
		String itemPriceOnCheckOutSearchScreen = au.findElement(itemPrice).get(0).getText();
		itemPriceOnCheckOutSearchScreen = itemPriceOnCheckOutSearchScreen.replace(" ", "").replace(",", "")
				.replace(".00", "");
		
		//Asserting deatils capturen on both screens
		Assert.assertEquals(itemNameOnSearchScreen, itemNameOnCheckOutScreen);
		Assert.assertTrue(itemPriceOnSearchScreen.contains(itemPriceOnCheckOutSearchScreen.split("\\$")[1]));
	}

}
