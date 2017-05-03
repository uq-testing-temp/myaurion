@Timesheet
Feature: Timesheet
  As a casual employee
  I want to be able to login to the My Aurion system
  So that I can submit my timesheet
  
 # Background:
  #	Given I am on myAurion login page
   #	  And I enter username as "uqasmi46"
    #  And I enter password as "password123"
     # And I click Login button
      
  @now
  Scenario: Submit timesheet using daily form as a casual employee
  Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I select the daily timesheet
  		And I select the timekeeper as "24/12/2016"
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
  		
  		
  Scenario Outline: Submit timesheet using period form for single day
  	Given I am on timesheet page
  		And I select the period timesheet
  		And I select the timekeeper as "21/01/2017"
  		And I click on Edit button
  		And I add contact hours button for day "<day>"
  		And I select the date
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save button
  		And I click on Done button
  	When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  	Examples:
  	|day|
  	|Mon|
  	
  	
  Scenario Outline: Submit timesheet using period form for multiple days
  	Given I am on timesheet page
  		And I select the period timesheet
  		And I select the timekeeper as "21/01/2017"
  		And I click on Edit button
  		And I add contact hours button for day "<day>"
  		And I select the date "<date1>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save & New button
  		
  		And I select the date "<date2>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save & New button
  		
  		And I select the date "<date3>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save button
  		And I click on Done button
  	When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  	Examples:
  	| day | date1 | date2 | date3 |
  	| Mon |       |       |       |
  	
  	
  	
 Scenario: Submit timesheet using detailed form single day
  	Given I am on timesheet page
  		And I select the Detailed timesheet
  		And I select the timekeeper as "21/01/2017"
  		And I click on Add button
  		And I select the date
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save button
   	When I click on submit timesheet
  		And I enter the message as " Please approve- this is a test for detailed view single day"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  		
  		
 Scenario Outline: Submit timesheet using detailed form multiple days
  	Given I am on timesheet page
  		And I select the Detailed timesheet
  		And I select the timekeeper as "21/01/2017"
  		And I click on Add button
  		And I select the date "<date1>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save & New button
  		
  		And I select the date "<date2>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save & New button
  		
  		And I select the date "<date3>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save button
   	When I click on submit timesheet
  		And I enter the message as " Please approve- this is a test for detailed view single day"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  	Examples:
  	| day | date1 | date2 | date3 |
  	| Mon |       |       |       |
  		
  		
  		
  Scenario: Reset the timesheet on daily form before submit
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
  	When I click on Reset timesheet
  		And I click OK button in pop up 
  	Then I should see the timesheet is reset message displayed
  	     
  	     
  	     
   Scenario Outline: Reset timesheet using period form
  	Given I am on timesheet page
  		And I select the period timesheet
  		And I select the timekeeper as "21/01/2017"
  		And I click on Edit button
  		And I add contact hours button for day "<day>"
  		And I select the date
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save button
  		And I click on Done button
  	When I click on Reset timesheet
  		And I click OK button in pop up 
  	Then I should see the timesheet is reset message displayed
  	
  	Examples:
  	|day|
  	|Mon|
  	
  
  #	Try Submit time sheet as a fixed term/continuing employee and verify that time sheet is disabled
  	
  	@now
  	Scenario: Try Submit timesheet as a fixed term/continuing employee
  	Given I am on myAurion login page
   	  And I enter username as "uqmsanda"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
 Then I should see the timesheet not available message displayed
  	
  	
  #	Select timesheet from Timesheet full list page
  @now	
  Scenario: As a casual employee view the timesheets in Full list view
  Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  	And I click on View full list
  	Then I should see full list of my timesheets
  	
  	
  	
  	#Enter hours with missing start/finish time and Save
  	@now
  Scenario: Try to Submit timesheet without entering start time or end time and verify the error
  Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I select the daily timesheet
  		And I select the timekeeper as "07/01/2017"
  		And I add contact hours button
  		And I select the date
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		#And I enter stop time as "17:00"
  		And I click on save
 Then I should see the timesheet warning alert message displayed
  	