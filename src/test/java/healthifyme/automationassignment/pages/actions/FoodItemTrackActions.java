/*
 Here we write the code for all the actions performed for performing
 foodObjective adding and verification
 */

package healthifyme.automationassignment.pages.actions;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import healthifyme.automationassignment.pages.HomePage;
import healthifyme.automationassignment.pages.LeaderboardPage;
import healthifyme.automationassignment.utills.AppiumUtilities;

public class FoodItemTrackActions implements  HomePage,LeaderboardPage {

	private AppiumUtilities au = null;

	public FoodItemTrackActions(AndroidDriver<MobileElement> driver) {
		try {
			au = new AppiumUtilities(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * perform the login action in HealthifyMe app
	 */
	public void trackFoodObjective(String foodObjectiveText) {
		Reporter.log("Tap on me tab");
		au.tap(meTab);
		WebElement foodObjectTick = null;
		Reporter.log("scrolling opened objective page");
		au.scroll(0.6, 0.3, 0.5);
		Reporter.log("iterate over all the objectives and find food Objective element");
		for (WebElement elem : au.findElement(objectiveCard)) {
			if (elem.findElement(objectiveCardTitleTextView).getText()
					.contains(foodObjectiveText)) {
				Reporter.log("store imageview element on food Objective card in an webelement");
				foodObjectTick = elem.findElement(imageView);
				Reporter.log("Tap on food Objective element");
				elem.click();
				break;
			}

		}
		Reporter.log("Select breakfast from Which meal would you like to track? page");
		au.findElement(selectBreakFast).get(0).click();
		
		Reporter.log("Search the item you want to have for brakfast");
		au.enterText(breakfastSearchBar, "Milk");
		au.hideKeybord();
		
		Reporter.log("get the list of all search results of breakfast items");
		WebElement parentElem = au.findElement(breakfastItemSearchResult).get(0);
		List<WebElement> searchItems = parentElem.findElements(linearLayout);
		int size = searchItems.size();
		Random rand = new Random();
		int index = rand.nextInt(size - 1);
		Reporter.log("Select any food item randomly");
		WebElement singleSearchResult = searchItems.get(index);
		
		Reporter.log("selected breakfast item is "+singleSearchResult.findElement(textView).getText());
		singleSearchResult.click();

		Reporter.log("add selected food item to breakfast");
		au.tap(addToBreakFast);

		Reporter.log("Tap on done button");
		au.tap(doneButton);
		
		Reporter.log("Tap on me tab");
		au.tap(meTab);
		
		Reporter.log("Assert green tick for the food objective card");
		Assert.assertTrue(foodObjectTick.getAttribute("resourceId").contains("ll_objective_done"));
		
		Reporter.log("Food Objective Verification Is SuccessFull");
	}

}
