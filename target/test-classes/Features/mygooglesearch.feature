Feature: feature to test google functionality

  Scenario: Validate google search is working
    Given browser is open
    And user is on google search page
    When user enters a text in the search box
    And hits enter
    Then user is navigated to search results
