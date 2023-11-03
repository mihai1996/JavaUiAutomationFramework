Feature: Register Flow Test Suit
  Scenario: Register Page can be accessed from Home Page
    Given HomePage is displayed
    When registerLink from Header is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    Given "/index.php?route=account/register" end point is accessed
    When the register form is populated with valid random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: The user remains on Register Page when the continue button is not clicked
    Given "/index.php?route=account/register" end point is accessed
    When the register form is populated with valid random data
    Then the current url contains "route=account/register" keyword