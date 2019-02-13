/*
 Here we store element locators for Leaderbord Page opened after
 tapping Me tab
 */

package healthifyme.automationassignment.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public interface LeaderboardPage {
	
	By objectiveCard = MobileBy.id("com.healthifyme.basic:id/card_objective");
	By objectiveCardTitleTextView = MobileBy.id("com.healthifyme.basic:id/tv_card_title");
	By imageView = MobileBy.className("android.widget.ImageView");
	By selectBreakFast = MobileBy.id("com.healthifyme.basic:id/breakfast_layout");
	By breakfastSearchBar = MobileBy.id("com.healthifyme.basic:id/et_search");
	By breakfastItemSearchResult = MobileBy.id("com.healthifyme.basic:id/rv_search_results");
	By linearLayout= MobileBy.className("android.widget.LinearLayout");
	By textView = MobileBy.className("android.widget.TextView");
	By addToBreakFast = MobileBy.id("com.healthifyme.basic:id/btn_add");
	By doneButton = MobileBy.id("com.healthifyme.basic:id/btn_done");
}