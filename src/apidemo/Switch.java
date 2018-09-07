package apidemo;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Switch extends Setup {

	@Test
	public void switchClick() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Preference\")").click();
		driver.findElementByAndroidUIAutomator("text(\"9. Switch\")").click();

		// driver.findElementById("android:id/checkbox").click();

		//driver.findElementsByClassName("android.widget.LinearLayout").get(1).click();
		TouchAction t = new TouchAction(driver);
		
		 /* t.longPress(driver.findElementByAndroidUIAutomator("text(\"OFF\")"))
		 * .moveTo(driver.findElementByAndroidUIAutomator("text(\"ON\")")).release().
		 * perform();
		 */
		t.press(driver.findElementByXPath("//android.widget.Switch[@text='OFF']")).waitAction(Duration.ofMillis(2000))
				.moveTo(driver.findElementByXPath("//android.widget.Switch[@text='ON']")).release().perform();

		//MobileElement mt= (MobileElement)driver.findElementByXPath("//android.widget.Switch[@text='OFF']");
		
		
	}

}
