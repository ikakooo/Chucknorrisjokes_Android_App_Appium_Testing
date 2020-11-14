import io.appium.java_client.AppiumDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL


class TestAndroidApp {
    lateinit var androidDriver: AppiumDriver<WebElement>

    @Before
    fun driverAndEmulatorSetup() {
        val cap = DesiredCapabilities()
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554")
        cap.setCapability("platformName", "android")
        cap.setCapability("appPackage","com.example.chucknorrisjokes")
        cap.setCapability("appActivity",".ui.SplashScreenActivity")
        cap.setCapability("noReset",true)
        androidDriver = AppiumDriver(URL("http://localhost:4723/wd/hub"),cap)
    }

    @Test
    fun splashScreenTest() {
    Assert.assertNotNull(androidDriver.context)
    }


}