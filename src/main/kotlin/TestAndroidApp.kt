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
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        cap.setCapability("platformName", "android")
        cap.setCapability("appPackage", "com.example.chucknorrisjokes")
        cap.setCapability("appActivity", ".ui.SplashScreenActivity")
        cap.setCapability("noReset", true)
        androidDriver = AppiumDriver(URL("http://localhost:4723/wd/hub"), cap)
        Thread.sleep(2000)
    }

    @Test
    fun splashScreenTest() {
        Assert.assertNotNull(androidDriver.context)
    }

    @Test
    fun showJokesActivityTest() {
        val randomButton = androidDriver.findElementById("com.example.chucknorrisjokes:id/random_Button_ID")
        val jokeTextContent = androidDriver.findElementById("com.example.chucknorrisjokes:id/Text_viewID")
        val openFavoriteActivityButton =
            androidDriver.findElementById("com.example.chucknorrisjokes:id/favorite_ImageView_ID")
        val openCategoryActivityButton =
            androidDriver.findElementById("com.example.chucknorrisjokes:id/choseCategory_Button_ID")
        val likingButton = androidDriver.findElementById("com.example.chucknorrisjokes:id/choseCategory_Button_ID")
        val oldText = jokeTextContent.text
        randomButton.click()
        Assert.assertNotEquals(oldText,jokeTextContent.text)
    }

    @Test
    fun markJokeCategoryActivityTest() {


    }

    @Test
    fun favoritesActivityTest() {


    }

//    @After
//    fun quiteTests() {
//        androidDriver.close()
//        androidDriver.quit()
//    }


}