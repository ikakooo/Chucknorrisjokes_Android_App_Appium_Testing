package tests_runner

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import tests_runner.ProjectParams.AVD
import java.net.URL

open class BaseRunner {
   // var threadLocalDriver: ThreadLocalDriver = ThreadLocalDriver
    lateinit var driver: AndroidDriver<WebElement>

    @BeforeMethod
    fun driverAndEmulatorSetup() {
        val remoteURL = URL("http://localhost:4723/wd/hub")
        val cap = DesiredCapabilities()


        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        cap.setCapability("platformName", "android")
        cap.setCapability("avd", AVD);
        cap.setCapability("appPackage", "ikakooo.chkhitu.chucknorrisjokes")
        cap.setCapability("appActivity", ".ui.SplashScreenActivity")
        cap.setCapability("autoGrantPermissions", true)
        cap.setCapability("newCommandTimeout", 120)
        cap.setCapability("appium:uiautomator2ServerInstallTimeout", 120000)
        cap.setCapability("appium:adbExecTimeout", 120000)
        cap.setCapability("appium:androidInstallTimeout", 120000)
        cap.setCapability("appWaitDuration", 120000)
        cap.setCapability("noReset", false)


        ThreadLocalDriver.setTlDriver(AndroidDriver(remoteURL, cap))
        driver = ThreadLocalDriver.getTLDriver()
    }


    @AfterMethod
    @Synchronized
    open fun tearDown() {
        // quit the driver
        driver.quit()
    }


}