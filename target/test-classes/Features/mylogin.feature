Feature: feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page that should contain <message>

    Examples: |
      | username | password | message |
      | Tufail   |    12345 | Tufail  |
      | Richard  |    12345 | Richard |
      | Neena    |    12345 | Neena   |
      | jay      |    12345 | jay     |
