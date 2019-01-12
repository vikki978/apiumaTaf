/*
 Here we store element locators for Product Search Page
 */

package wipro.automationassignment.pages;

import org.openqa.selenium.By;

public interface ProductSearchPage {
	
	By itemName1 = By.id("com.ebay.mobile:id/textview_item_name");
	By itemPrice1 = By.id("com.ebay.mobile:id/textview_item_price");
	By buyNowButton = By.id("com.ebay.mobile:id/button_bin");
	By addToCartButton = By.id("com.ebay.mobile:id/button_add_to_cart");
	By reviewButton = By.id("com.ebay.mobile:id/take_action");

}