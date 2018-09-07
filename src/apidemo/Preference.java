package apidemo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class Preference extends Setup {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	public void preference_test() throws MalformedURLException {
		driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Preference\")").click();
		driver.findElementByAndroidUIAutomator("text(\"1. Preferences from XML\")").click();
		driver.findElementsByClassName("android.widget.CheckBox").get(0).click();
		driver.findElementByAndroidUIAutomator("text(\"Edit text preference\")").click();

		String expectedTitle = "Enter your favorite animal";
		String actualTitle = driver.findElementById("android:id/alertTitle").getText();
		System.out.println(actualTitle);

		if (actualTitle.equals(expectedTitle)) {
			driver.findElementById("android:id/edit").sendKeys("Elephant");
			driver.findElementByAndroidUIAutomator("text(\"OK\")").click();

		} else {
			driver.findElementByAndroidUIAutomator("text(\"CANCEL\")").click();
		}
		driver.findElementByAndroidUIAutomator("text(\"List preference\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Beta Option 02\")").click();
		// Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("text(\"Screen preference\")").click();
		driver.findElementById("android:id/checkbox").click();
		driver.pressKeyCode(AndroidKeyCode.BACK);

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Child checkbox preference\"))");

		driver.findElementsByClassName("android.widget.CheckBox").get(1).click();
		// Thread.sleep(3000);

		driver.findElementsByClassName("android.widget.CheckBox").get(2).click();
	}

}
