package steps.android_ui_elements

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

object NavigationsTests {

     fun AndroidDriver<WebElement>.activityChanged(SpendingTime:Long){
       val oldActivity= currentActivity()
        Thread.sleep(SpendingTime)
       Assert.assertNotEquals(oldActivity,currentActivity())
    }

    fun AndroidDriver<WebElement>.activityChangedOnButtonClick(button:WebElement){
        val oldActivity= currentActivity()
        button.click()
        Assert.assertNotEquals(oldActivity,currentActivity())
        navigate().back()
    }
}