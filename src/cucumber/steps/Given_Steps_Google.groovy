package steps

import Helpers.StringHelper
import static cucumber.api.groovy.EN.*


Given(~/^I am on "([^"]*)" page$/) { String pagePrettyName ->
    String pageName
    switch (pagePrettyName){
        case "Google":
            pageName = "GooglePage"
            break
    }
    to Class.forName("pages." + pageName)
    at Class.forName("pages." + pageName)

}

When(~/^I search for the keyword "([^"]*)"$/) { String keyword ->
    page.search(keyword)

}

Then(~/^results for "([^"]*)" are displayed$/) { String keyword ->
    assert page.displayedSearchResults.size() > 0
    page.displayedSearchResults.each{
        assert StringHelper.removeAccents(it.text().toLowerCase()).contains(StringHelper.removeAccents(keyword.toLowerCase()))
        assert page.getElementHref(it) != ""
    }

}

Then(~/^no match warning message is displayed for the the keyword "([^"]*)"$/) { String keyword ->
    assert page.getHeadingParagraph().contains("Your search - "+keyword+" - did not match any documents.")
}
