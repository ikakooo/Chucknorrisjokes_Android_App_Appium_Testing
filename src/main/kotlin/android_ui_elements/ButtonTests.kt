package android_ui_elements

import io.appium.java_client.android.AndroidDriver
import org.junit.Assert
import org.openqa.selenium.WebElement

object ButtonTests {
    fun AndroidDriver<WebElement>.randomButtonWillChangeJoke(clickingTimesCount: Int) {
        val randomButton = findElementById("com.example.chucknorrisjokes:id/random_Button_ID")
        val jokeTextContent = findElementById("com.example.chucknorrisjokes:id/Text_viewID")
        repeat(clickingTimesCount) {
            val oldJokeText = jokeTextContent.text
            randomButton.click()
            oldJokeText != jokeTextContent.text
            Assert.assertNotEquals(oldJokeText, jokeTextContent.text)
        }

    }
}