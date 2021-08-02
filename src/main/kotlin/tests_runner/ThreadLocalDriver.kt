package tests_runner

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement

object ThreadLocalDriver {
    private val tlDriver = ThreadLocal<AndroidDriver<WebElement>>()

    @Synchronized
    fun setTlDriver(driver: AndroidDriver<WebElement>) {
        tlDriver.set(driver)
    }

    @Synchronized
    fun getTLDriver(): AndroidDriver<WebElement> {
        return tlDriver.get()
    }
}