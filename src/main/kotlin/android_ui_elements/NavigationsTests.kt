package android_ui_elements

import io.appium.java_client.android.AndroidDriver
import org.junit.Assert
import org.openqa.selenium.WebElement

object NavigationsTests {

     fun AndroidDriver<WebElement>.activityChanged(SpendingTime:Long){
       val oldActivity= currentActivity()
        Thread.sleep(SpendingTime)
       Assert.assertNotEquals(oldActivity,currentActivity())
    }
}