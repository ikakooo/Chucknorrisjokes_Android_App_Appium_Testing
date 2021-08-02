package steps

import io.appium.java_client.android.AndroidDriver
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class NewHelperSteps(private var driver: AndroidDriver<WebElement>) {

    @Step("waiting to Element visible. max waiting time in sec is: {0} ")
    fun By.waitToElementVisible(timeOutInSeconds: Long) {
        val waitForElement = WebDriverWait(driver, timeOutInSeconds)
        waitForElement.until(ExpectedConditions.elementToBeClickable(this))
    }

    @Step("is Element Displayed?")
    fun By.elementIsDisplayed(): Boolean = try {
        driver.findElement(this).isDisplayed
    } catch (e: Exception) {
        false
    }

    @Step("Element clicked")
    fun By.clickToElement() {
        waitToElementVisible(3)
        driver.findElement(this).click()

    }

    @Step("Element clicked with max waiting time in sec: {0}")
    fun By.clickToElement(timeOutInSeconds: Long) {
        waitToElementVisible(timeOutInSeconds)
        driver.findElement(this).click()
    }

    @Step("Reading text from element")
    fun By.readText(): String {
        waitToElementVisible(3)
        return driver.findElement(this).text
    }
    @Step("Reading text from element with max waiting time in sec: {0}")
    fun By.readText(timeOutInSeconds: Long): String {
        waitToElementVisible(3)
        return driver.findElement(this).text
    }

}