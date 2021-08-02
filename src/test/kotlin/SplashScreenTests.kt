import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.Test
import pages.SplashScreenPage.splash_screen
import tests_runner.BaseRunner

class SplashScreenTests: BaseRunner() {

    @Test
    fun visibilityTimeSplashScreen(){
        //splash_screen.waitToElementVisible(driver,10)


        Assert.assertTrue(driver.findElement(splash_screen).isDisplayed)
    }

    @Test
    fun visibilityOfChuckPhotoOnSplashScreen(){

    }

}