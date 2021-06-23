package pages
import geb.Page
import org.openqa.selenium.Keys

class GooglePage extends Page{
    static atCheckWaiting = true
    static url = ""
    static at = {

        waitFor
                {
                    searchInput.isDisplayed()
                }
    }
    static content = {
        searchInput { $("input[name='q']") }
        displayedSearchResults(wait: true) { $("#res a h3[class='LC20lb DKV0Md']").findAll { it.displayed }}
        buttonAcceptPrivacy (wait: true) { $("#L2AGLb")}
        headParagraph (wait: true) {$("#res p[role='heading']")}
      }

    def search(String keyword) {
        waitFor { buttonAcceptPrivacy.click() }
        waitFor { searchInput.value(keyword) }
        searchInput  << Keys.chord(Keys.ENTER)
    }

    def getSearchResultByIndex(int index){
        return displayedSearchResults.getAt(index)
    }

    def getElementHref(Object element){
        return element.parent('a').getAttribute('href')
    }

    def getHeadingParagraph(){
        return this.headParagraph.text()
    }

}
