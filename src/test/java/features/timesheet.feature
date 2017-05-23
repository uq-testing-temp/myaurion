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
      
  @Automated
  Scenario:  Casual staff - Enter, Validate and Submit Timesheet- Daily view
  Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I select the daily timesheet
  		And I select the timekeeper as "26/11/2016"
  		And I add contact hours button
  		And I select the date to enter time "20161128"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save
  		And I Close the notification
  	When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
   	
  
  		
  @Automated	
  Scenario Outline: Casual staff - Enter, Validate and Submit Timesheet-Period view
  
  	 Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I select the timekeeper as "<StartDate>"
  		And I select the view "Period"
 		And I click on Edit button
 		And I click on period view Add button
  		And I select the date to enter time "<WhichDay>"
  		And I select contact hours type
 		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "12:00"
  		And I click on save
  		And I Close the notification
  		And I click on Done
  		When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  	Examples:
  	|StartDate|WhichDay|
  	|10/12/2016|20161212|
  	|25/06/2016|20160705|
  	
  	
  	
  	
  	 @Automated	
  Scenario Outline: Casual staff - Enter, Validate and Submit Timesheet-Detailed view
  
  	 Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I select the timekeeper as "24/12/2016"
  		And I select the view "Detailed"
 		And I click on detailed view Add button
 		And I select the date to enter time "<WhichDay>"
  		And I select contact hours type
 		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save
  		And I Close the notification
  		When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  	Examples:
  	|WhichDay|
  	|20161226|
  	
  		
  	
  	@Automated
  Scenario Outline:  Supervisor - Enter, Validate and Submit Timesheet-on behalf of employee
  Given I am on myAurion login page
   	  And I enter username as "uqsjone3"
      And I enter password as "password123"
      And I click Login button
      And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
  	Given I am on timesheet page
  		And I select the daily timesheet
  		And I select the timekeeper as "12/11/2016"
  		And I add contact hours button
  		And I select the date to enter time "20161115"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save
  	When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  	Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |SOLOMON, Kathleen      |SOLOMON, Kathleen|
  		
  		
  

  
  #	Try Submit time sheet as a fixed term/continuing employee and verify that time sheet is disabled
  	
  	@Automated
  	Scenario: Try Submit timesheet as a fixed term or continuing employee
  	Given I am on myAurion login page
   	  And I enter username as "uqksolom"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
 Then I should see the timesheet not available message displayed
  	
  	
  #	Select timesheet from Timesheet full list page
  @Automated	
  Scenario: As a casual employee view the timesheets in Full list view
  Given I am on myAurion login page
   	  And I enter username as "uqksolom"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  	And I click on View full list
  	Then I should see full list of my timesheets
  	
  	
  	
  	
 

 # Save and Copy timesheet entry
  @Automated
 Scenario: Save and Copy timesheet entry
  Given I am on myAurion login page
   	  And I enter username as "uqksolom"
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
  		And I enter stop time as "17:00"
  		And I click on SaveandCopy button
  		And I Close the notification
  		#And I add contact hours button
  		And I select another date
  		And I select contact hours type
  		And I enter course code as "testing copy"
  		And I enter start time as "09:00"
  		And I enter stop time as "17:00"
  		And I click on save  		
 Then I should see the timesheet is saved message displayed
 
 
 
  #Default Time sheets
 
 @Automated	
  Scenario: Casual staff - Create or Remove a Default Timesheet: Create default timesheet from current timesheet
  Given I am on myAurion login page
   	  And I enter username as "uqksolom"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  	And I click on View full list
  	And I select the current timesheet
  	And I click on Set as Default button and click OK
 Then I should see the timesheet is saved message displayed
 
 
#Populate timesheets with default values
 
 @Automated	
  Scenario: Casual staff - Create or Remove a Default Timesheet-Create default timesheet from previous timesheet
  Given I am on myAurion login page
   	  And I enter username as "uqksolom"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  	And I select the daily timesheet
  	And I select the timekeeper as "07/01/2017"
  	And I click on Reset button and click OK
  Then I should see the timesheet is saved message displayed
 
 
 
 
 
 #Enter hours with missing start/finish time and Save
  	@Automated
  Scenario: Try to Submit timesheet without entering start time or end time and verify the error
  Given I am on myAurion login page
   	  And I enter username as "uqksolom"
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
 
 
 
@Automated
 Scenario Outline:  Supervisor of casual staff - Review and Approve Timesheet
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Timesheet Approvals"
 		And I click on "Latest"button for "Timesheet Approvals"
 		And I select the timesheet dated "<TimesheetStartdate>"and of employee"<EmployeeName>"
 		And I action the timesheet "<Action>"
 		And I enter the reference message as "this is a automation test for Timesheet Approval"
 		And I click on Approve button
   	Then I should see workflow action successful message displayed
   	
   		Examples:
  |TimesheetStartdate|Action|EmployeeName|
  |26/11/2016        |Approve| Adam Smith|
  	
  	
  		 @Automated
 Scenario Outline:  Supervisor of casual staff - Review and Decline Timesheet
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Timesheet Approvals"
 		And I click on "Latest"button for "Timesheet Approvals"
 		And I select the timesheet dated "<TimesheetStartdate>"and of employee"<EmployeeName>"
 		And I action the timesheet "<Action>"
 		And I enter the reference message as "this is a automation test for Timesheet Decline"
 		And I click on Decline button
   	Then I should see workflow action successful message displayed
   	
   		Examples:
  |TimesheetStartdate|Action|EmployeeName|
  |10/12/2016        |Decline| Adam Smith|
  
  
  
   @Automated
 Scenario Outline:  Supervisor of casual staff - Review and Return Timesheet
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Timesheet Approvals"
 		And I click on "Latest"button for "Timesheet Approvals"
 		And I select the timesheet dated "<TimesheetStartdate>"and of employee"<EmployeeName>"
 		And I action the timesheet "<Action>"
 		And I enter the reference message as "this is a automation test for Timesheet Return"
 		And I click on Return button
   	Then I should see workflow action successful message displayed
   	
   		Examples:
  |TimesheetStartdate|Action|EmployeeName|
  |24/12/2016        |Return|Adam Smith  |
  	
  	
  	   @Automated	
 Scenario Outline:  Supervisor of casual staff - Review and Edit Timesheet
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Timesheet Approvals"
 		And I click on "Latest"button for "Timesheet Approvals"
 		And I select the timesheet dated "<TimesheetStartdate>"and of employee"<EmployeeName>"
 		And I select the view "Period"
 		And I click on Edit button
 		And I click on period view Add button
  		And I select the date to enter time "<WhichDay>"
  		And I select contact hours type
 		And I enter course code as "test"
  		And I enter start time as "14:00"
  		And I enter stop time as "17:00"
  		And I click on save
		Then I should see the timesheet Line is saved message displayed
  		And I Close the notification
 		And I click on Done
		And I action the timesheet "<Action>"
 		And I enter the reference message as "this is a automation test for Review, Update and Timesheet Approval"
 		And I click on Approve button
   	Then I should see workflow action successful message displayed
	
   	
   		Examples:
  |TimesheetStartdate|Action |WhichDay|EmployeeName|
  |25/06/2016        |Approve|20160706|Adam Smith  |
  
  
  
  	   @Automated
 Scenario Outline:  Supervisor of casual staff - Review and Edit Current Timesheet
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Timesheet Approvals"
 		And I click on "Latest"button for "Timesheet Approvals"
 		And I select the timesheet dated "<TimesheetStartdate>"and of employee"<EmployeeName>"
 		And I select the view "Daily"
 		And I add contact hours button
  		And I select the date to enter time "<WhichDay>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save
  		Then I should see the timesheet Line is saved message displayed
  		And I Close the notification
 		#And I click on Done
	And I action the timesheet "<Action>"
 		And I enter the reference message as "this is a automation test for Review, Update and Timesheet Approval"
 		And I click on Approve button
   	Then I should see workflow action successful message displayed
   	
   		Examples:
  |TimesheetStartdate|Action |WhichDay|EmployeeName|
  |25/06/2016        |Approve|20160707|Adam Smith  |
  
  
  
   	   @Automated	
 Scenario Outline:  Supervisor of casual staff - Review and Update Timesheet using Detailed View
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Timesheet Approvals"
 		And I click on "Latest"button for "Timesheet Approvals"
 		And I select the timesheet dated "<TimesheetStartdate>"and of employee"<EmployeeName>"
 		And I select the view "Detailed"
 		And I click on detailed view Add button
 		And I select the date to enter time "<WhichDay>"
  		And I select contact hours type
 		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save
  		Then I should see the timesheet Line is saved message displayed
  		And I Close the notification
 		#And I click on Done
	And I action the timesheet "<Action>"
 		And I enter the reference message as "this is a automation test for Review, Update and Timesheet Approval"
 		And I click on Approve button
   	Then I should see workflow action successful message displayed
	
   	
   		Examples:
  |TimesheetStartdate|Action |WhichDay|EmployeeName|
  |25/06/2016        |Approve|20160708|Adam Smith  |
  
  
  
  
  
  
  
  
 
    	 	  @Automated	
  Scenario Outline: Casual staff - Update Declined Timesheet and Resubmit
  
  	 Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I click on View full list
  		And I select the timesheet from full list "<Dated>"
  		And click on show from button
  		And I select the daily timesheet
  		And I add contact hours button
  		And I select the date to enter time "<WhichDay>"
  		And I select contact hours type
  		And I enter course code as "test"
  		And I enter start time as "08:00"
  		And I enter stop time as "17:00"
  		And I click on save
  		Then I should see the timesheet Line is saved message displayed
  		And I Close the notification
  		When I click on submit timesheet
  		And I enter the message as " Please approve this is a test"
  		And I click submit button 
  	Then I should see the timesheet is saved message displayed
  	
  	Examples:
  	|WhichDay|Dated      |
  	|20161213|10/12/2016 |
  	
  	
  	
  	
  	 	 @Automated
  Scenario Outline: Casual staff - Update Returned Timesheet and Resubmit
  
  	 Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	  When I am on MyTasks page
  		And I select My tasks action "Timesheet Approvals"
 		And I click on "Latest"button for "Timesheet Approvals"
 		And I select the timesheet dated "<TimesheetStartdate>"and of employee"<Supervisor>"
  	    And I click on Forward button
  	    And I enter the reference message as " Please approve this is a test"
  		And I click submit button
  	Then I should see workflow action successful message displayed
  	
  	Examples:
  	|Supervisor|TimesheetStartdate     |
  	|Daniel Angus  |24/12/2016 |
  	
  
 	 @Automated
  Scenario Outline: Casual staff - Recall Approved Timesheet (not yet paid)
  
  	 Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I click on View full list
  		And I select the timesheet from full list "<Dated>"
  		And click on show from button
  		And I perform recall timesheet action
   	Then I should see the timesheet recalled message displayed
  	
  	Examples:
  	|Dated      |
  	|26/11/2016 |
  	
  	
  	
  	  
 
    @Automated
  Scenario Outline: Casual staff - Recall Submitted Timesheet
  
  	 Given I am on myAurion login page
   	  And I enter username as "uqasmi46"
      And I enter password as "password123"
      And I click Login button
  	Given I am on timesheet page
  		And I click on View full list
  		And I select the timesheet from full list "<Dated>"
  		And click on show from button
  		And I perform recall timesheet action
   	Then I should see the timesheet recalled message displayed
  	
  	Examples:
  	|Dated      |
  	|25/06/2016 |
  
  
  
  
  
  
  
  
  
    	
 	
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
  		And I click on save
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
  	