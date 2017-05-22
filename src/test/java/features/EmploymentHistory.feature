@EmploymentHistory
Feature: Employmet_history
As a user
I want to be able to login to the My Aurion system
So that I can View my employment history


    

 
 @Automated
 Scenario: Fixed Term Continuing staff - View Job Details, Employment History and Acting Placements
 
 Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
 	When I navigate to Employment history page
 		And I select the current placement position
 	Then I should see my current placement details
 	
 	
 	
 	
 @Automated
 Scenario: Casual staff - View Job Details, Employment History and Acting Placements
 
 Given I am on myAurion login page
   	  And I enter username as "uqckel10"
      And I enter password as "password123"
      And I click Login button
 	When I navigate to Employment history page
 		And I select the current placement position
 	Then I should see my current placement details
 	
 	
 	
 	
 	
 	
 	
 	
 	Scenario: View current acting active placement
 	When I am on Employment History page
 		And I select the current acting active placement
 	Then I should see my current acting active placement details
 