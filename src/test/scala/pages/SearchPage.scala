package pages

import org.openqa.selenium.{By, WebElement}
import org.scalatest.Matchers
import org.scalatest.selenium.WebBrowser
import utils.Driver

import scala.collection.JavaConversions._

trait SearchPage extends Driver with WebBrowser with Matchers{

  val baseUrl = "https://link.springer.com"
  val searchTextField = "query"

  def getSearchTextField: WebElement = waitAndGet(By.id(searchTextField))

  def getResultByLinkText(linkName:String): WebElement = waitAndGet(By.linkText(linkName))

  def getDOIOfLink(linkName:String): String = waitAndGet(By.linkText(linkName)).getCssValue("href")

  def getCurrentUrl: String = driver.getCurrentUrl

  def getPageTitle: WebElement = waitAndGet(By.xpath("//div[@id='book-title']/h1"))

  def getDisciplineFacetLink(disciplineName:String): WebElement = {
    driver.findElements(By.cssSelector("#discipline-facet .facet-link")).toList
      .filter(elem => elem.findElement(By.className("facet-title")).getText.equals(disciplineName)).head
  }

  def getSelectedFilter(): WebElement = waitAndGet(By.xpath("//a[@title='Remove this filter']"))

}
