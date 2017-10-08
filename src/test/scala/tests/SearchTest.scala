package tests

import steps.SearchPageSteps


class SearchTest extends SearchPageSteps{
  val bookTitle = "Engineering Education for a Smart Society"
  val disciplineOne = "Engineering"
  val disciplineTwo = "Computer Science"

  describe("My Search Functionality"){
    it("should allow users to search by a book title"){
      openApplication()
      searchByKeyword(bookTitle)
      verifySearchResult(bookTitle)
    }

    it("should allow users to navigate to the document detail page on clicking title link"){
      navigateToSearchDetailsPage(bookTitle)
      verifySearchDetailsPage(bookTitle)
    }

  }

  describe("My Search Functionality"){
    it("should allow users to filter results based on a discipline"){
      openApplication()
      searchByKeyword(bookTitle)
      verifySearchResult(bookTitle)
      selectDisciplineFacet(disciplineOne)
      verifyDisciplineSelected(disciplineOne)
    }

    it("should allow users to remove filter and refine results again"){
      deSelectFacet(disciplineOne)
      selectDisciplineFacet(disciplineTwo)
    }

  }
}
