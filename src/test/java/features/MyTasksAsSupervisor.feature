@MyTasksAsSupervisor
Feature: Training & Courses
As a supervisor
I want to be able to login to the My Aurion system
So that I can View my requested courses and course history


Background:
    Given I am on myAurion login page
   	  And I enter username as "uqmsanda"
      And I enter password as "password123"
      And I click Login button
      
      
Scenario: View pending training applications
  	When I am on MyTasks page
  		And I select Payroll action "Training Applications"
 		And I click on "Latest" button 
   	Then I should see pending Training Applications in my queue
   	
   	
   	
   	
  Scenario: View Approved Training Applications
  	When I am on MyTasks page
  		And I select Payroll action "Training Applications"
 		And I click on "Approved" button 
   	Then I should see Approved Training Applications in my queue
   	
   	
   	
  Scenario: View Cancelled Training Applications
  	When I am on MyTasks page
  		And I select Payroll action "Training Applications"
 		And I click on "Cancelled" button 
   	Then I should see cancelled Training Applications in my queue
   	
   	
   	
   	
   	 Scenario: Approve leaves  "<------Need login for this, yet to work on these------>"
  When I am on MyTasks page
  		And I select Payroll action "Training Applications"
 		And I click on "Latest" button 
   Then I should see pending Training Applications in my queue
   	
   	
   	   	 Scenario: Decline leaves "<------Need login for this, yet to work on these------>"
  	When I am on MyTasks page
  		And I select Payroll action "Training Applications"
 		And I click on "Latest" button 
   	Then I should see pending Training Applications in my queue
   	
   	
   	 	   	 Scenario: Return leaves "<------Need login for this, yet to work on these------>"
  	When I am on MyTasks page
  		And I select Payroll action "Training Applications"
 		And I click on "Latest" button 
   	Then I should see pending Training Applications in my queue