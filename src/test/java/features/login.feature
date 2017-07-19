@Login
Feature: Login
  As a user
  I want to be able to login to the My Aurion system
  So that I can manage my personal account

  Background:
    Given I am on myAurion login page

  @smoke
  Scenario Outline: Login - Positive Scenario

    When I enter username as "<username>"
      And I enter password as "<password>"
      And I click Login button
    Then I should be logged in

    Examples:
    | username | password    |
    | uqdbende | password123 |

  @smoke
  Scenario Outline: Login - Negative Scenario

    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click Login button
    Then I should not be logged in

    Examples:
      | username | password    |
      | uqdbende | password    |