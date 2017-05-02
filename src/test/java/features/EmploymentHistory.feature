@EmploymentHistory
Feature: Employmet_history
As a user
I want to be able to login to the My Aurion system
So that I can View my employment history

Background:
    Given I am on myAurion login page
   	  And I enter username as "uqmsanda"
      And I enter password as "password123"
      And I click Login button

 
 
 Scenario: View current placement
 	When I am on Employment History page
 		And I select the current placement position "Principal Admin Officer"
 	Then I should see my current placement details
 	
 	
 	Scenario: View current acting active placement
 	When I am on Employment History page
 		And I select the current acting active placement
 	Then I should see my current acting active placement details
 