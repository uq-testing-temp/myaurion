@regression
@smoke
@menujourney
Feature: Login
  As a user
  I want to be able to login to the My Aurion system
  So that I can manage my personal account

  Background:
    Given I am on myAurion login page

  Scenario: Going trough all links

    When I enter username as "<username>"
      And I enter password as "<password>"
      And I click Login button
    Then I should be able to go through all links