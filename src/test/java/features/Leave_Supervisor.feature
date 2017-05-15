@LeaveSupervisor
Feature: Leave
  As a supervisor/manager
  I want to be able to login to the My Aurion system
  So that I can view/approve/reject leave applications
  
  Background:
    Given I am on myAurion login page
   	  And I enter username as "uqmsanda"
      And I enter password as "password123"
      And I click Login button
  
  
  
  Scenario: View pending leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	
   	
   	
  Scenario: View Approved leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Approved" button 
   	Then I should see Approved leave applications in my queue
   	
   	
   	
  Scenario: View Cancelled leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Cancelled" button 
   	Then I should see cancelled leave applications in my queue
   	
   	
   	
   	
   	 Scenario: Approve leaves  
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	
   	   	 Scenario: Decline leaves "<------Need login for this, yet to work on these------>"
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	
   	 	   	 Scenario: Return leaves "<------Need login for this, yet to work on these------>"
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	
   	
   	 Scenario: View pending leave reversals
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Latest" button 
   	Then I should see pending leave reversals in my queue
   	
   	
   	
   	
  Scenario: View Approved leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Approved" button 
   	Then I should see Approved leave reversals in my queue
   	
   	
   	
  Scenario: View Cancelled leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Cancelled" button 
   	Then I should see cancelled leave reversals in my queue
   	
   	
   	
   	
   	 Scenario: Approve leaves  "<------Need login for this, yet to work on these------>"
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	
   	   	 Scenario: Decline leaves "<------Need login for this, yet to work on these------>"
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	
   	 	   	 Scenario: Return leaves "<------Need login for this, yet to work on these------>"
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	