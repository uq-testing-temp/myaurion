@HRProfile
Feature: HR Profile
As a supervisor
I want to be able to login to the My Aurion system
So that I can view my HR Profile details

@Automated
Scenario: MyAurion - Fixed Term Continuing staff - View HR Profile

Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
When I navigate to HR Profile page
Then I should be able to see the Qualifications,Licences and Inductions details