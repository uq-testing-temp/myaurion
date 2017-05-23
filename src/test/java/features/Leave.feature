@Leave
Feature: Leave
  As a user
  I want to be able to login to the My Aurion system
  So that I can apply a single day leave
  
  #Background:
   # Given I am on myAurion login page
   	#  And I enter username as "uqdbende"
     # And I enter password as "password123"
      # And I click Login button
  @Automated
  Scenario Outline: Fixed Term Continuing staff: Apply for Leave- Apply a single day leave
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I click on Apply for Leave button
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Single Full Day"
  		And I select the start date"<StartDate>"
  		And I enter the message as "this is a automation test for single day leave"
  		And I click submit button
  	Then I should see the success message is displayed
  	
  	Examples:
  	|StartDate |
  	|01/09/2017|
  	|04/09/2017|
  	|05/09/2017|
  	

@Automated
   Scenario Outline: Fixed Term Continuing staff: Apply for Leave- Apply multiple days leave
  	 Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I click on Apply for Leave button
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Multiple Full Days"
  		And I select the start date"<StartDate>"
  		And I select the end date"<EndDate>"
  		And I enter the message as "this is a automation test for Multiple days leave"
  		And I click submit button
  	Then I should see the success message is displayed
  	
  	
  	Examples:
  	|StartDate | EndDate  |
  	|06/09/2017|07/09/2017|
  	
  	
  	
  @Automated
  Scenario Outline: View my current Recreational leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Recreational" leave balances displayed in days"<Rec_Available>""<Rec_Pending>""<Rec_Balance>"
  	
  		Examples:
  	|Rec_Available | Rec_Pending  |Rec_Balance|Pers_Available | Pers_Pending  |Pers_Balance|
  	|14.46         |0.00	      |    14.46  |                |            | |
  	
  	
  	
  	 @Automated
  Scenario Outline: View my current  Personal  leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Personal" leave balances displayed in days"<Pers_Available>""<Pers_Pending>""<Pers_Balance>"
  	
  		Examples:
  	|Pers_Available | Pers_Pending  |Pers_Balance|
  	|36.73         |0.00	      |    36.73 | 
  	
  	
  	
  	 	
  	 @Automated
  Scenario Outline: View my current Sick leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Sick" leave balances displayed in days"<Sick_Available>""<Sick_Pending>""<Sick_Balance>"
  	
  		Examples:
  	|Sick_Available | Sick_Pending  |Sick_Balance|
  	|35.00         |0.00	      |    35.00 | 
  	
  	
  		 	
  	 @Automated
  Scenario Outline: View my current Carer's leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Carer" leave balances displayed in days"<Care_Available>""<Care_Pending>""<Care_Balance>"
  	
  		Examples:
  	|Care_Available | Care_Pending  |Care_Balance|
  	|5.00         |0.00	      |    5.00 | 
  	
  	
  	
  	
  	  	 @Automated
  Scenario Outline: View my current Long Service leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdangus"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Long Service" leave balances displayed in days"<LS_Available>""<LS_Pending>""<LS_Balance>"
  	
  		Examples:
  	|LS_Available | LS_Pending  |LS_Balance|
  	|23.87        |0.00	      |    23.87 | 
  	
  	
  	
  	
  Scenario: View my current leave balances
  	When I am on a leave page
  	And  I select hours button
  	Then I should see my leave balances displayed in hours
  	
  	
 @Automated	
 Scenario Outline: Fixed Term Continuing staff - Predict Leave Balances
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
	And  I am on leave page
 		And I enter a future date"<futuredate>"
 		And I click on the Predict button
 	Then I should see my predicted leave balances displayed
 	
 	Examples:
 	|futuredate|
    |10/08/2017|
 
 
 Scenario: View my leave history
  	When I am on a leave page
  	Then I should see my leave history displayed
  	


   @Automated   
  	Scenario:  Fixed Term Continuing staff - Delete Pending Leave Request
  	Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I select my pending leave request
  	And I click on Delete button
  	Then I should see Delete success message displayed
  	
  	
  	@Automated
  	 	 Scenario Outline:  Supervisor of fixed term continuing staff - Approve Leave Request
  Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Leave Applications"
 		And I click on "Latest"button for "Leave Applications"
 		And I select the leave application for dated "<LeaveStartdate>"
 		And I action the leave request "<Action>"
 		And I enter the reference message as "this is a automation test for Leave Approval"
 		And I click on Approve button
   	Then I should see workflow action successful message displayed
   	
   		Examples:
  |LeaveStartdate|Action |
  |01/09/2017    |Approve|
  |04/09/2017    |Approve|
  	
  	
  	
  	@Automated
Scenario Outline: Fixed Term Continuing staff - Reverse Approved Leave Request End to End
Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
When I am on leave page
  	And I select my Approved leave request dated"<LeaveStartdate>"
  		And I action the leave request "<Action>"
 		And I enter the message as "this is a automation test for Forwarding leave request"
 		And I click submit button
Then I should see Leave reversal successful message displayed
   	
   		Examples:
  |LeaveStartdate|Action |
  |01/09/2017    |Reverse|
  	
   	
   	
   	
   	  	@Automated
 	 Scenario Outline:   Supervisor of fixed term continuing staff - Decline Leave Request
  Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
  When I am on MyTasks page
  		And I select My tasks action "Leave Applications"
 		And I click on "Latest"button for "Leave Applications"
 		And I select the leave application for dated "<LeaveStartdate>"
 		And I action the leave request "<Action>"
 		And I enter the reference message as "this is a automation test for Leave Decline"
 		And I click on Decline button
   	Then I should see workflow action successful message displayed
   	
   		Examples:
  |LeaveStartdate|Action |
  |05/09/2017    |Decline|
  
  
   	
  	@Automated
Scenario Outline:  Supervisor of fixed term continuing staff - Return Leave Request
Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
When I am on MyTasks page
  		And I select My tasks action "Leave Applications"
 		And I click on "Latest"button for "Leave Applications"
 		And I select the leave application for dated "<LeaveStartdate>"
 		And I action the leave request "<Action>"
 		And I enter the reference message as "this is a automation test for Leave Return"
 		And I click on Return button
Then I should see workflow action successful message displayed
   	
   		Examples:
  |LeaveStartdate|Action|
  |06/09/2017|Return|
   	
   	
   	
@Automated
Scenario Outline: Fixed Term Continuing staff - Actioning Returned Leave Request (Forward)
Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
When I am on MyTasks page
  		And I select My tasks action "Leave Applications"
 		And I click on "Latest"button for "Leave Applications"
 		And I select the leave application for dated "<LeaveStartdate>"
 		And I action the leave request "<Action>"
 		And I enter the reference message as "this is a automation test for Forwarding leave request"
 		And I click on Forward button
Then I should see workflow action successful message displayed
   	
   		Examples:
  |LeaveStartdate|Action|
  |06/09/2017|Forward|
   	
  
  
@Automated
Scenario: Fixed Term Continuing staff - Actioning Returned Leave Request (Delete)
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I select my pending leave request
  	And I click on Delete button
  	Then I should see Delete success message displayed
   	
   	
   	
   	Scenario Outline:  Fixed Term Continuing staff - Delete Pending Leave Request
  	Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I select my pending leave request from date"<StartDate>"to date"<EndDate>"
  	And I click on Delete button
  	Then I should see Delete success message displayed
  	
  	Examples:
  	|StartDate | EndDate  |
  	|11/07/2017|11/07/2017|
  
   	
   	
   	
   	
   	
   	
   	
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
   	
   	
   	
   	 
   	
  	

  	
  	
  	