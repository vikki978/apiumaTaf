/*
 Here we store element locators for CheckOut Page
 */

package wipro.automationassignment.pages;

import org.openqa.selenium.By;

public interface CheckOutPage {
	
	By pageTitle = By.id("com.ebay.mobile:id/toolbar_centered_title");
	By itemName = By.id("com.ebay.mobile:id/item_title");
	By itemPrice = By.id("com.ebay.mobile:id/item_price");

}