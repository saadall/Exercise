@UI @GoogleSearch
Feature: Google Searching without matching results

Scenario Outline: searche using keyword not matching any results
    Given I am on "Google" page
    When I search for the keyword "<keyword>"
    Then no match warning message is displayed for the the keyword "<keyword>"

    Examples:
      | keyword               |
      | [[`\^@\`\|[{#{[`\^    |


