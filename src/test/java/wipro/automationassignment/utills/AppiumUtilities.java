/*
 Here we write the wrapper around appium actions used in our framework
 for automating desired testcases.
 */

package wipro.automationassignment.utills;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumUtilities {

	private AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait;

	public AppiumUtilities(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 160);
	}

	public List<MobileElement> findElement(By elem) {
		return driver.findElements(elem);
	}

	public void tap(By elem) {
		WebElement element = findElement(elem).get(0);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		Reporter.log("Tapped successfully on " + elem);
	}

	public void clickByIndex(By elem, int index) {
		WebElement element = findElement(elem).get(index);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void quitDriver() {
		driver.quit();
	}

	public boolean isVisible(By elem) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elem));
		if (findElement(elem).isEmpty()) {
			return false;
		} else {
			return findElement(elem).get(0).isDisplayed();
		}
	}

	public void enterText(By elem, String text) {
		findElement(elem).get(0).sendKeys(text);
	}

	public void enterTextByIndex(By elem, String text, int index) {
		findElement(elem).get(index).setValue(text);
	}

	public void hideKeybord() {

		try {
			driver.hideKeyboard();
		} catch (Exception e) {
		}

	}

	public void goBack() {
		driver.navigate().back();
	}

	public void waitForPageLoad(By elem) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elem));
	}

	public void waitForElement(By elem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
	}

	public void pressKeyboardEnter() {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

}
