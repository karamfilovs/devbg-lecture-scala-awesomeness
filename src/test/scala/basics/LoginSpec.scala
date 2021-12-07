package basics

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class LoginSpec extends AnyWordSpec with should.Matchers {
  "User" should {
    "be able to login with valid username and password" in {
      val browser = BrowserTypes.chrome.launch(BrowserTypes.defaultLaunchOptions)
      val page = browser.newPage()
      page.navigate("https://st2016.inv.bg")
      val heading1 = page.textContent("//h1")
      val heading2 = page.textContent("//h2")
      page.fill("#loginusername", "karamfilovs@gmail.com")
      page.fill("#loginpassword", "123456")
      //Wait for the user to login
      page.waitForNavigation(() => page.click("input.selenium-submit-button"))
      val loggedUser = page.textContent("div.userpanel-header")
      loggedUser shouldBe "karamfilovs@gmail.com"
    }

    "not be able to login with invalid password" in {
      val browser = BrowserTypes.chrome.launch()
      val page = browser.newPage()
      page.navigate("https://st2016.inv.bg")
      val heading1 = page.textContent("//h1")
      heading1 shouldBe "QA Ground"
      val heading2 = page.textContent("//h2")
      page.fill("#loginusername", "karamfilovs@gmail.com")
      page.fill("#loginpassword", "12345678")
      page.click("input.selenium-submit-button")
      val errorMessage = page.textContent("#error")
      errorMessage shouldBe "Грешка"
    }
  }

}
