@regression
@smoke
@login
Feature: Login
  As a user
  I want to be able to login to the My Aurion system
  So that I can manage my personal account

  Background:
    Given I am on myAurion login page

  Scenario Outline: Login - Positive Scenario

    When I enter username as "<username>"
      And I enter password as "<password>"
      And I click Login button
    Then I should <result>

    Examples:
    | username | password    | 	result 				|
    | uqdbende | password123 |	be logged in 		|
    | uqdbende | password    |  not be logged in	| 