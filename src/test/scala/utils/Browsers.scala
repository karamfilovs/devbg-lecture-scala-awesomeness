package utils

import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.{Browser, BrowserType, Page, Playwright}

object Browsers  {
  private val Options = new LaunchOptions().setHeadless(false)
  val Chrome: BrowserType = Playwright.create().chromium()
  val Firefox: BrowserType = Playwright.create().firefox()
  val Webkit: BrowserType = Playwright.create().webkit()
  val All: List[BrowserType] = List(Chrome, Firefox, Webkit) //To be able to iterate

  //Using default args for launch options
  def launchBrowser(browserType: BrowserType, launchOptions: LaunchOptions = Options): Browser = {
    browserType.launch(launchOptions)
  }

  def launchPage(browserType: BrowserType, launchOptions: LaunchOptions = Options): Page = {
    browserType.launch(launchOptions).newPage()
  }

}
