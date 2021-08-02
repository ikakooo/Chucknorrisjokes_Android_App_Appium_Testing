import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.SplashScreenPage

//fun <T, G> T.waitToElement(ika: G) {
//    waitToElement(1)
////}
//
//fun By.waitToElementVisible(driver: AndroidDriver<WebElement>, timeOutInSeconds: Long) {
//    val waitForElement = WebDriverWait(driver, timeOutInSeconds)
//    waitForElement.until(ExpectedConditions.elementToBeClickable(this))
//}
//
//fun By.elementIsDisplayed(driver: AndroidDriver<WebElement>): Boolean = try {
//    driver.findElement(this).isDisplayed
//} catch (e: Exception) {
//    false
//}