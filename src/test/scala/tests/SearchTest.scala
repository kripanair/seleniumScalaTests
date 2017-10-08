package tests

import steps.SearchPageSteps


class SearchTest extends SearchPageSteps{
  val bookTitle = "Engineering Education for a Smart Society"
  val disciplineOne = "Engineering"
  val disciplineTwo = "Computer Science"

  describe("On searching for a book title user"){
    it("should be able to view relevant search results"){
      openApplication()
      searchByKeyword(bookTitle)
      verifySearchResult(bookTitle)
    }

    it("should be able view and click the search result "){
      navigateToSearchDetailsPage(bookTitle)
      verifySearchDetailsPage(bookTitle)
    }

  }

  describe("On filtering the search result user"){
    it("should be able to narrow down the results"){
      openApplication()
      searchByKeyword(bookTitle)
      verifySearchResult(bookTitle)
      selectDisciplineFacet(disciplineOne)
      verifyDisciplineSelected(disciplineOne)
    }

    it("should be able to further narrow down results by deselecting and selecting facets"){
      deSelectFacet(disciplineOne)
      selectDisciplineFacet(disciplineTwo)
    }

  }
}
