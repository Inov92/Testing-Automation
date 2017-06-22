Feature: LoginFeature
Scenario Outline: Invalid login
Given  I am on home page
When I login as "<login>" and "<password>"
Then Failed message is visible
  And close browser
  Examples:
  @sources: src/main/resources/login.csv
    | login  | password |
    |Иван|311292|
    |Никита|150294|
    |Слава|080890|
    |Стёпа|150589|
