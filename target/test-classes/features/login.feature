Feature: Login Funtionality

  Scenario Outline: login with valid credentials
    Given user should navigates to login page
    When user enter valid email address <username> into email field
    And user enter valid password <password> into password field
    And user clicks on login button
    Then user should successfully logged in

    Examples: 
      | username       | password  |
      | kck@gmail.com  | 123456789 |
      | kck1@gmail.com | 123456789 |
      | kck2@gmail.com | 123456789 |

  Scenario: login with invalid credentials
    Given user should navigates to login page
    When user enter invalid email address into email field
    And user enter invalid password "123xxqr2342j" into password field
    And user clicks on login button
    Then user should get warning message as no match found

  Scenario: login with invalid email and valid password
    Given user should navigates to login page
    When user enter invalid email address into email field
    And user enter valid password "123456789" into password field
    And user clicks on login button
    Then user should get warning message as no match found

  Scenario: login with valid email and invalid password
    Given user should navigates to login page
    When user enter valid email address "xyz@gmail.com" into email field
    And user enter invalid password "123xxqr2342j" into password field
    And user clicks on login button
    Then user should get warning message as no match found

  Scenario: login without providing any credentials
    Given user should navigates to login page
    When user dont enter email address into email field
    And user dont enter password into password field
    And user clicks on login button
    Then user should get warning message as no match found
