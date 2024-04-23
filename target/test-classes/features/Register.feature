Feature: Register Functionality

  Scenario: user creates an account with all mandatory fields
    Given user navigates to resgister account page
    When user enters the details into below fields
      | firstname        | Ram                  |
      | lastname         | pothuri              |
      | telephone        |           9988776644 |
      | password         |               123456 |
    And user selects priacy policy
    And user clicks on continue butoon
    Then user account should be created successfully

  Scenario: user creates an account with all fields
    Given user navigates to resgister account page
    When user enters the details into below fields
      | firstname        | Ramana                  |
      | lastname         | Krishna              |
      | telephone        |           9988776633 |
      | password         |               1234567 |
    And user selects yes for privacy policy
    And user selects priacy policy
    And user clicks on continue butoon
    Then user account should be created successfully

  Scenario: user creates an dupicate account
    Given user navigates to resgister account page
    When user enters the details into below fields with duplicate email
      | firstname        | Ram                  |
      | lastname         | pothuri              |
      | email            | rampothuri@gmail.com |
      | telephone        |           9988776644 |
      | password         |               123456 |
    And user selects yes for privacy policy
    And user selects priacy policy
    And user clicks on continue butoon
    Then user should  get warning message as  email registered already

  Scenario: user creates an account without filling any details
    Given user navigates to resgister account page
    When user does not enter any details into fields
    And clicks on continue button
    Then user should get warning message of all mandatory fields
