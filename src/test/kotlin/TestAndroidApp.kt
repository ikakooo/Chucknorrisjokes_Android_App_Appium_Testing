import steps.android_ui_elements.ButtonTests.randomButtonWillChangeJoke
import steps.android_ui_elements.NavigationsTests.activityChanged
import steps.android_ui_elements.NavigationsTests.activityChangedOnButtonClick
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.Assert
import java.net.URL


class TestAndroidApp {
    lateinit var driver: AndroidDriver<WebElement>
    //lateinit var androidDriver: AndroidDriver<WebElement>

    fun driverAndEmulatorSetup() {
        val cap = DesiredCapabilities()
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        // cap.setCapability(CapabilityType.PLATFORM_NAME,"android")
        cap.setCapability("platformName", "android")
        cap.setCapability("appPackage", "com.example.chucknorrisjokes")
        cap.setCapability("appActivity", ".ui.SplashScreenActivity")
        cap.setCapability("noReset", true)
        driver = AndroidDriver(URL("http://localhost:4723/wd/hub"), cap)
        // Thread.sleep(2000)
    }


    fun splashScreenTest() {
        Assert.assertNotNull(driver.context)
        driver.apply {
            activityChanged(3000)
        }
    }


    fun showJokesActivityTest() {
        Thread.sleep(3000)
        driver.activityChanged(3000)
        println(driver.currentPackage + driver.currentActivity())
        // (driver as AndroidDriver).startActivity(Activity("com.example.chucknorrisjokes", "MarkJokeCategoryActivity"))
//        val androidDriver = driver as AndroidDriver<MobileElement>
//        androidDriver.startActivity(
//            Activity(
//                "com.example.chucknorrisjokes",
//                ".ui.MarkJokeCategoryActivity"
//            ).setAppWaitPackage("com.example.chucknorrisjokes")
//                .setAppWaitActivity(".ui.MarkJokeCategoryActivity")
//        )

        driver.apply {
            val openFavoriteActivityButton = findElementById("com.example.chucknorrisjokes:id/favorite_ImageView_ID")
            val openCategoryActivityButton = findElementById("com.example.chucknorrisjokes:id/choseCategory_Button_ID")
            val likingButton = findElementById("com.example.chucknorrisjokes:id/favorite_Button_ID")
            println( likingButton.getCssValue("color"))
            likingButton.click()
            println( likingButton.getCssValue("color"))
            randomButtonWillChangeJoke(20)
            //  navigate().back()
            activityChangedOnButtonClick(openFavoriteActivityButton)

        }
    }

//    @Test
//    fun startActivityWithWaitingAppTestCase() {
//        val activity = Activity(
//            "io.appium.android.apis",
//            ".accessibility.AccessibilityNodeProviderActivity"
//        )
//            .setAppWaitPackage("io.appium.android.apis")
//            .setAppWaitActivity(".accessibility.AccessibilityNodeProviderActivity")
//        driver.startActivity(activity)
//        assertEquals(
//            driver.currentActivity(),
//            ".accessibility.AccessibilityNodeProviderActivity"
//        )
//    }


    fun markJokeCategoryActivityTest() {


    }
    fun favoritesActivityTest() {


    }


//    @AfterClass
//    fun quiteTests() {
//        driver.close()
//        driver.quit()
//    }


}