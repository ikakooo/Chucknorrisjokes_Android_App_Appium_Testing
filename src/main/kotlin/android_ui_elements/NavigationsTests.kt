package android_ui_elements

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement

object NavigationsTests {

     fun AndroidDriver<WebElement>.activityChanged(SpendingTime:Long):Boolean{
       val oldActivity= currentActivity()
        Thread.sleep(SpendingTime)
        return oldActivity!=currentActivity()
    }
}