Feature: Search Functionality

  Scenario: User searches for an valid product
    Given user navigates to home page
    When user enters valid product "HP" into search field
    And user clicks on search button
    Then user should get valid product details

  Scenario: User searches for  an invalid product
    Given user navigates to home page
    When user enters invalid product "Honda" into search field
    And user clicks on search button
    Then user should get a message about no product matched

  Scenario: User searchs without any product
    Given user navigates to home page
    When user does not enters any product into search field
    And user clicks on search button
    Then user should get a message about no product matched
