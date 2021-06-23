@UI @GoogleSearch
Feature: Google Searching with expected results
  As a web surfer, I want to search Google, so that I can learn new things.

  Scenario Outline: Google searches using simple keyword
    Given I am on "Google" page
    When I search for the keyword "<keyword>"
    Then no match warning message is displayed for the the keyword "<keyword>"

    Examples:
      | keyword               |
      | [[`\^@\`\|[{#{[`\^    |


