package specs

import com.microsoft.playwright.{Browser, Page}
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach}
import utils.Browsers

class LoginSpec extends AnyWordSpec with should.Matchers with BeforeAndAfterAll with BeforeAndAfterEach {
  private var browser: Browser = _
  private var page: Page = _

  override def beforeAll(): Unit = {
    browser = Browsers.launchBrowser(Browsers.Chrome) //launch browser before all tests
  }

  override def afterAll(): Unit = {
    browser.close() //Close browser after all tests
  }

  override def beforeEach(): Unit = {
    //Starting new incognito page before every test
    page = browser.newPage()
    //Navigating to base url before every test
    page.navigate("https://st2016.inv.bg")
  }

  override def afterEach(): Unit = {
    page.close() //Close incognito page after each test
  }


  "User" should {
    "be able to login with valid username and password" in {
      val heading1 = page.textContent("//h1")
      heading1 shouldBe "Вход в inv.bg"
      page.fill("#loginusername", "karamfilovs@gmail.com")
      page.fill("#loginpassword", "123456")
      //Wait for the user to login
      page.waitForNavigation(() => page.click("input.selenium-submit-button"))
      val loggedUser = page.textContent("div.userpanel-header")
      loggedUser shouldBe "karamfilovs@gmail.com"
      page.close()
    }

    "not be able to login with invalid password" in {
      val heading1 = page.textContent("//h1")
      heading1 shouldBe "Вход в inv.bg"
      //Typing text in the field located by selector
      page.fill("#loginusername", "karamfilovs@gmail.com")
      page.fill("#loginpassword", "12345678")
      page.click("input.selenium-submit-button")
      //Retrieving the text from element located by selector
      val errorMessage = page.textContent("#error")
      errorMessage should include ("Грешно потребителско име или парола. Моля, опитайте отново.")
    }

    "be able to login with valid username and password and logout" in {
      val heading1 = page.textContent("//h1")
      heading1 shouldBe "Вход в inv.bg"
      page.fill("#loginusername", "karamfilovs@gmail.com")
      page.fill("#loginpassword", "123456")
      //Wait for the user to login
      page.waitForNavigation(() => page.click("input.selenium-submit-button"))
      val loggedUser = page.textContent("div.userpanel-header")
      loggedUser shouldBe "karamfilovs@gmail.com"
      //Expand menu
      page.click("div.userpanel-header")
      //Click Logout link
      page.waitForNavigation(() => page.click("a.selenium-button-logout"))
      //Check logout success message
      val successMessage = page.textContent("#okmsg")
      successMessage should include ("Вие излязохте от акаунта си.")
    }


  }

}
