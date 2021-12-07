package basics

import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.{BrowserType, Playwright}

object BrowserTypes  {
  val defaultLaunchOptions = new LaunchOptions().setHeadless(false)
  val chrome: BrowserType = Playwright.create().chromium()
  val firefox: BrowserType = Playwright.create().firefox()
  val webkit: BrowserType = Playwright.create().webkit()
  val all: List[BrowserType] = List(chrome, firefox, webkit)

}
