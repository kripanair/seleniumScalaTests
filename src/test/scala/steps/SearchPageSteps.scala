package steps

import org.openqa.selenium.Keys
import org.scalatest.Assertion
import pages.SearchPage

class SearchPageSteps extends SearchPage{

  def openApplication(): Unit = go.to(baseUrl)

  def searchByKeyword(searchParam: String): Unit ={
    getSearchTextField.sendKeys(searchParam)
    getSearchTextField.sendKeys(Keys.ENTER)
  }

  def verifySearchResult(searchResult: String): Assertion ={
    getResultByLinkText(searchResult).isDisplayed should be(true)
  }

  def navigateToSearchDetailsPage(searchResult: String): Unit ={
    getResultByLinkText(searchResult).click()
  }

  def verifySearchDetailsPage(searchResult: String): Unit ={
    getPageTitle.getText should equal(searchResult)
  }

  def selectDisciplineFacet(disciplineName: String): Unit = {
    getDisciplineFacetLink(disciplineName).click()
  }

  def verifyDisciplineSelected(disciplineName: String): Unit ={
    getSelectedFilter.getText should be(disciplineName)
  }

  def deSelectFacet(disciplineName:String): Unit ={
    if(getSelectedFilter.getText equals disciplineName){
      getSelectedFilter.click()
    }
  }

  def clearSearch(): Unit = getClearSearchLink.click()

  def verifySearchIsCleared(): Unit = getCurrentUrl should equal (baseUrl+"/search")

  def verifySnippetImage(imageTitle: String): Assertion = getSnippetImageTitle(imageTitle).isDisplayed should equal (true)

  def verifySearchResultSummary(count:String , searchTerm: String): Assertion = getSearchSummary.getText should equal(s"$count Result(s) for '$searchTerm'")
}
