@Leave
Feature: Leave
  As a user
  I want to be able to login to the My Aurion system
  So that I can apply a single day leave
  
  Background:
    Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  @now
  Scenario: Apply a single day leave
  	When I am on a new leave page
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Single Full Day"
  		And I select the start date
  		And I enter the message as "this is a automation test for single day leave"
  		And I click submit button
  	Then I should see the success message is displayed

@now
   Scenario: Apply multiple days leave
  	When I am on a new leave page
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Multiple Full Days"
  		And I select the start date
  		And I select the end date
  		And I enter the message as "this is a automation test for Multiple days leave"
  		And I click submit button
  	Then I should see the success message is displayed
  	
  
  Scenario: View my current leave balances
  	When I am on  leave page
  	Then I should see my leave balances displayed in days
  	
  Scenario: View my current leave balances
  	When I am on a leave page
  	And  I select hours button
  	Then I should see my leave balances displayed in hours
  	
  	
 Scenario Outline: Predict my leave balances
	 When I am on leave page
 	And I enter a future date "<futuredate>"
 	And I click on the Predict button
 	Then I should see my predicted leave balances displayed
 	
 	Examples:
  |futuredate|
 
 
 Scenario: View my leave history
  	When I am on a leave page
  	Then I should see my leave history displayed
  	


      
  	Scenario: Delete unapproved leave request
  	When I select unapproved leave request
  	And I click on Delete button
  	Then I should see Delete success message displayed
  	
  
  	
  	
  	