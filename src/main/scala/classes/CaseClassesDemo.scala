package classes

import com.google.gson.GsonBuilder
import com.microsoft.playwright.{BrowserType, Page, Playwright}

class CaseClassesDemo {

}

trait IPage {
  def goTo(url: String): Boolean
}

class LoginPage(implicit val page: Page) extends IPage {
  override def goTo(url: String ): Boolean ={
    true
  }
}

case class Item(name: String, price: Double, unit: String)

case class Client(name: String, vatNumber: String)

case class Invoice(item: Item, client: Client)


object Demo extends App {
  //Gson object to serialize/deserialize objects
  val Gson = new GsonBuilder().setPrettyPrinting().create()
  //Case classes immutable intances
  val coffee = Item("Coffee", 20, "kg")
  val companyX = Client("Company X ltd", "BG120120120")
  val invoice10 = Invoice(coffee, companyX)

  //Serialize
  println(Gson.toJson(coffee))
  println(Gson.toJson(companyX))
  println(Gson.toJson(invoice10))

  //Deserialize (interpolated json string)
  val jsonItem =
    """{
      | "name" : "Better coffee",
      | "price": 50,
      | "unit": "gr"
      | }""".stripMargin
  println(jsonItem)
  //Converting json to object [Item]
  val betterCoffee = Gson.fromJson(jsonItem, classOf[Item])
  println(betterCoffee.name)
  println(betterCoffee.price)
  //Login page needs implicit value declared in the same context
  implicit val page: Page = Playwright.create()
    .webkit()
    .launch()
    .newPage()
  val loginPage = new LoginPage()
  println(loginPage.goTo("/login"))
}