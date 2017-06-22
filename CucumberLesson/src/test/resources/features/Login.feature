Feature: LoginFeature


  Scenario Outline: Login process

    Given I am on home page

    When I login as "<login>" and "<password>"

    Then Profile name is visible
    And close browser

    Examples:
      |login|password|
      |epam |1234    |





