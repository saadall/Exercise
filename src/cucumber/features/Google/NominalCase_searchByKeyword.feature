@UI @GoogleSearch
Feature: Google Searching without results

  @SanityChecks
  Scenario Outline: Google searches using keyword without matching results
    Given I am on "Google" page
    When I search for the keyword "<keyword>"
    Then results for "<keyword>" are displayed

    Examples:
      | keyword  |
      | panda    |
      | elephant |
      | éléphant |
      | SONEPAR  |
      | 幸福      |


