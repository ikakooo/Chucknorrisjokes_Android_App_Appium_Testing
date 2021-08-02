import io.qameta.allure.Description
import org.testng.Assert
import org.testng.annotations.Test
import pages.FavoritesListPage
import pages.JokesMainPage
import steps.NewHelperSteps
import tests_runner.BaseRunner

class JokesMainPageTests : BaseRunner() {


    @Test
    @Description("Visibility Of Random Button Test")
    fun visibilityOfRandomButtonTest() {
        JokesMainPage.apply {
            NewHelperSteps(driver).apply {

                random_Button.waitToElementVisible(10)

                // Assertions
                Assert.assertTrue(random_Button.elementIsDisplayed(), "Random button is not visible")
            }
        }
    }


    @Test
    @Description("Visibility Of Favorite Button Test")
    fun visibilityOfFavoriteButtonTest() {
        JokesMainPage.apply {
            NewHelperSteps(driver).apply {

                make_Joke_favorite_Button.waitToElementVisible(10)

                // Assertions
                Assert.assertTrue(make_Joke_favorite_Button.elementIsDisplayed(), "Favorite button is not visible")
            }
        }
    }

    @Test
    @Description("Random button will change Joke")
    fun randomButtonWillChangeJoke() {
        JokesMainPage.apply {
            NewHelperSteps(driver).apply {
                random_Button.waitToElementVisible(10)


                repeat(5) {
                    val oldJokeText = jokes_View.readText()
                    random_Button.clickToElement()

                    // Assertions
                    Assert.assertNotEquals(oldJokeText, jokes_View.readText())
                }
            }
        }
    }


    @Test
    @Description("Make Joke Favorite And Check If It Is Really In Favorites List")
    fun makeJokeFavoriteAndCheckIfItIsReallyInFavoritesList() {
        JokesMainPage.apply {
            FavoritesListPage.apply {
                NewHelperSteps(driver).apply {
                    make_Joke_favorite_Button.clickToElement(10)
                    val mainPageJokeText = jokes_View.readText()
                    favorites_list_Button.clickToElement()


                    // Assertions
                    Assert.assertEquals(mainPageJokeText, fJokeTextView.readText(5))
                }
            }
        }
    }

}