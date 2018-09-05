Feature: login to application

  As a use I want to be able to login to application

  Scenario: Login with correct credentials
    Given login page is open
    When user provides correct credentials
    And triggers login action
    Then page visible only to logged in users is shown


  Scenario Outline: Login with different credentials

      Given login page is open
      When user enters <login> and <password>
      And triggers login action
      Then Message <message> is visible
      And User is logged out


      Examples:
      | login     | password  | message                        |
      | admin     | password  | Przejdź na listę studentów  |
      | incorrect | incorrect | Wystąpił niespodziewany błąd!|

