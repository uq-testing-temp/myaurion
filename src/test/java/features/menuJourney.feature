@regression
@smoke
@menujourney
Feature: Login
  As a user
  I want to be able to login to the My Aurion system
  So that I can manage my personal account

  Background:
    Given I am on myAurion login page

@healthcheck
  Scenario: Going trough all links

    When I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
    Then I should be able to go through all links