@TrainingCourses
Feature: Training & Courses
As a user
I want to be able to login to the My Aurion system
So that I can View my requested courses and course history

Background:
    Given I am on myAurion login page
   	  And I enter username as "uqmsanda"
      And I enter password as "password123"
      And I click Login button

      
 Scenario Outline: Fixed Term Continuing staff - Search and apply for training course
 When I am on the Training courses page
 	And I select Training action "Requested Courses"
 	And I click on Add button
 	And I select the From date "<Fromdate>"
 	And I select the To date "<Todate>"
 	And I select the course type"<Type>"
 	And I select look in "<LookIn>"
 	And I select Course "<Course>"
 	And I select Learning Area "<LearningArea>"
 	And I select Program "<Programsearch>"
 	And I select Competency "<Competency>"
 	And I click on Search button
 	And I select the program from result "<Program>"
 	And I select Reason "<SelectReason>"
 	And I click on Apply button
 	And I enter the message as "this is a automation test for requesting new training course"
 	And I click on Submit button
 Then I should see the success message is displayed
 
 Examples:
  | Fromdate | Todate   | Type | LookIn | Course| LearningArea | Programsearch | Competency | Program | SelectReason |
  
  
  
  
  	Scenario: Supervisor of fixed term continuing staff - Decline Training Request
 Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
 When I am on the My Tasks page
 	And I select Training action "Training Applications"
 	And I select the latest unapproved application 
 	And I click on Decline button
 	And I enter message text
 	And I click on Decline button
Then I should see the success message is displayed
 


  	Scenario: Supervisor of fixed term continuing staff - Approve Training Request
 Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
 When I am on the My Tasks page
 	And I select Training action "Training Applications"
 	And I select the latest unapproved application 
 	And I click on Approve button
 	And I enter message text
 	And I click on Approve button
Then I should see the success message is displayed



  	Scenario:  Supervisor of fixed term continuing staff - Return Training Request
 Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
 When I am on the My Tasks page
 	And I select Training action "Training Applications"
 	And I select the latest unapproved application 
 	And I click on Return button
 	And I enter message text
 	And I click on Return button
Then I should see the success message is displayed
 

 	
 	
 	  Scenario Outline: Fixed Term Continuing staff - Actioning Returned Training Request 
 Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
When I am on the My Tasks page
 	And I select Training action "Training Applications"
 	And I select the latest unapproved application 
 	And I click on Forward button
 	And I enter message text
 	And I click on Forward button
Then I should see the success message is displayed
  
  Examples:
  | CourseName |
 	
  
  
  
  Scenario Outline: View unapproved requested courses 
 When I am on the Training courses page
 	And I select Training action "Requested Courses"
 	And I select the unapproved course "<CourseName>"
 Then I should see the course details
 
  Examples:
  | CourseName |
  
  
    Scenario Outline: View approved requested courses 
 When I am on the Training courses page
 	And I select Payroll action "Requested Courses"
 	And I select the approved course "<CourseName>"
 Then I should see the course details
 
  Examples:
  | CourseName |
  
  Scenario Outline: Cancel a requested course 
 When I am on the Training courses page
 	And I select Payroll action "Requested Courses"
 	And I select the approved course "<CourseName>"
 	And I click on Cancel request button
 Then I should see the course details <<??This is bombing on clicking Cancel button-- looks like a bug>>
 
  Examples:
  | CourseName |
  
  
   Scenario Outline: View Course history details 
 When I am on the Training courses page
 	And I select Payroll action "Course History"
 	And I select the unapproved course "<CourseName>"
 Then I should see the course details
 
  Examples:
  | CourseName |
 	
 	
 