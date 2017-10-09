package tests

import steps.SearchPageSteps


class SearchTest extends SearchPageSteps {
  val bookTitle = "Engineering Education for a Smart Society"
  val disciplineOne = "Engineering"
  val disciplineTwo = "Computer Science"
  val searchTermWithOperator = "engineering education for smart society AND Michael E. Auer"
  val searchTermWithNoResults = "frank loeffler gynaecologist AND Kasireddy"
  val zeroSearchCount = "0"
  val searchCountOne = "19,653"
  val searchCountTwo = "3,175"
  val searchCountThree = "5,096"

  describe("On searching for a book title") {
    it("user should be able to view relevant search results") {
      openApplication()
      searchByKeyword(bookTitle)
      verifySearchResultSummary(searchCountOne, bookTitle)
      verifySearchResult(bookTitle)
    }

    it("user should be able view and click the search result ") {
      navigateToSearchDetailsPage(bookTitle)
      verifySearchDetailsPage(bookTitle)
    }

  }

  describe("On filtering the search result") {
    it("user should be able to narrow down the results") {
      openApplication()
      searchByKeyword(bookTitle)
      verifySearchResult(bookTitle)
      selectDisciplineFacet(disciplineOne)
      verifySearchResultSummary(searchCountTwo, bookTitle)
      verifyDisciplineSelected(disciplineOne)
    }

    it("user should be able to further narrow down results by deselecting and selecting facets") {
      deSelectFacet(disciplineOne)
      selectDisciplineFacet(disciplineTwo)
      verifySearchResultSummary(searchCountThree, bookTitle)
      verifyDisciplineSelected(disciplineTwo)
    }

    it("and clicking on New Search link user should be able to clear old search") {
      clearSearch()
      verifySearchIsCleared()
    }
  }

  describe("Relevant results should be displayed on searching using operator") {
    it("AND for book title , author"){
      openApplication()
      searchByKeyword(searchTermWithOperator)
      verifySearchResult(bookTitle)
      verifySnippetImage(bookTitle)
    }
  }

  describe("Zero results page should be displayed when"){
    it("user searches for document that doesn't exist in the system"){
      openApplication()
      searchByKeyword(searchTermWithNoResults)
      verifySearchResultSummary(zeroSearchCount, searchTermWithNoResults)
    }

  }
}
