@Timesheet
Feature: Leave
  As a user
  I want to be able to login to the My Aurion system
  So that I can submit my timesheet
  
  Background:
  	Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
      
  @now
  Scenario: Submit timesheet using daily form
  	Given I am on timesheet page
  		And I select the daily timesheet
  		And I select the timekeeper as "21/01/2017"
  		And I add contact hours button
  		And I select the date
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save
  	When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  		
  		
  		
  	     