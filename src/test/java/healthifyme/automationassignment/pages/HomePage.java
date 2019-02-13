/*
 Here we store element locators for Home Page
 */

package healthifyme.automationassignment.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public interface HomePage {
	
	By dashbord = MobileBy.id("com.healthifyme.basic:id/ll_action_bar_dashboard");
	By homeTab = MobileBy.xpath("//android.widget.TextView[@text='Home']");
	By PlansTab = MobileBy.xpath("//android.widget.TextView[@text='Plans']");
	By meTab = MobileBy.xpath("//android.widget.TextView[@text='Me']");
	By homeFoodsTab = MobileBy.xpath("//android.widget.TextView[@text='Health Foods']");

}