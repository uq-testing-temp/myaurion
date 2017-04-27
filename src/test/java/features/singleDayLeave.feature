@Leave
Feature: Leave
  As a user
  I want to be able to login to the My Aurion system
  So that I can apply a single day leave
  
  Background:
    Given I am on myAurion login page
   	  And I enter username as "uqmsanda"
      And I enter password as "password123"
      And I click Login button
  
  Scenario: Apply a single day leave
  	When I am on a new leave page
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Single Full Day"
  		And I select the start date
  		And I enter the message as "this is a automation test for single day leave"
  		And I click submit button
  	Then I should see the success message is displayed

   Scenario: Apply multiple days leave
  	When I am on a new leave page
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Multiple Full Days"
  		And I select the start date
  		And I select the end date
  		And I enter the message as "this is a automation test for Multiple days leave"
  		And I click submit button
  	Then I should see the success message is displayed
  	
  	
  	