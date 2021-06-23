@UI @GoogleSearch
Feature: Google Searching with expected results

  @SanityChecks
  Scenario Outline: searche using simple keyword
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


