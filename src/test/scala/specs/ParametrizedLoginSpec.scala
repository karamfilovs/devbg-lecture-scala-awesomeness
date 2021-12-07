package specs

import org.scalatest.matchers.must.Matchers.include
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec
import utils.Browsers

class ParametrizedLoginSpec extends AnyWordSpec with should.Matchers {


  "User" should {
    "be able to login and logout" in {
      Browsers.All.foreach(br => {
        println(s"Starting browser: ${br.name()}")
        val page = Browsers.launchBrowser(br).newPage()
        println("Navigating to Login page")
        page.navigate("https://st2016.inv.bg")
        val heading1 = page.textContent("//h1")
        heading1 shouldBe "Вход в inv.bg"
        println("Entering username")
        page.fill("#loginusername", "karamfilovs@gmail.com")
        println("Entering password")
        page.fill("#loginpassword", "123456")
        //Wait for the user to login
        println("Clicking Login button")
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
        page.close()
    })
  }

  }
}
