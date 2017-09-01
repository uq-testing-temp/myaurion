Feature: Leave
  As a user
  I want to be able to login to the My Aurion system
  So that I can apply a single day leave

@Leave
  Scenario: Fixed Term Continuing staff: Apply for Leave- Apply a single day leave
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I click on Apply for Leave button
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Full Day"
  		And I select the start date as 35 days in the future
  		And I enter the message as "this is a automation test for single day leave"
  		And I click submit button
  	Then I should see the success message is displayed if there is no overlapping days

  	
@Leave
   Scenario: Fixed Term Continuing staff: Apply for Leave- Apply multiple days leave
  	 Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I click on Apply for Leave button
  		And I select the leave type as "Annual/Recreation (Recreation)"
  		And I select the duration as "Multiple Days"
  		And I select the start date as 35 days in the future
  		And I select the end date as 40 days in the future
  		And I enter the message as "this is a automation test for Multiple days leave"
  		And I click submit button
  	Then I should see the success message is displayed if there is no overlapping days
  	

  	
  	
# TODO: Dependency. Not feasible to automate without data setup. 
# Solution: smoke tests to check that fields are present and days properly translated into hours when click on HOURS
  @_Leave
  Scenario Outline: View my current Recreational leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Recreation" leave balances displayed in days"<Rec_Available>""<Rec_Pending>""<Rec_Balance>"
  	
  		Examples:
  	|Rec_Available | Rec_Pending  |Rec_Balance|Pers_Available | Pers_Pending  |Pers_Balance|
  	|21.77         |2.00	      |    19.77  |                |            | |
  	

# TODO: Dependency. Not feasible to automate without data setup. 
# Solution: smoke tests to check that fields are present and days properly translated into hours when click on HOURS
@_Leave
  Scenario Outline: View my current  Personal  leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Personal" leave balances displayed in days"<Pers_Available>""<Pers_Pending>""<Pers_Balance>"
  	
  		Examples:
  	|Pers_Available | Pers_Pending  |Pers_Balance|
  	|32.18         |0.00	      |    32.18 | 
  	
  	
# TODO: Dependency. Not feasible to automate without data setup. 
# Solution: smoke tests to check that fields are present and days properly translated into hours when click on HOURS  	
@_Leave
  Scenario Outline: View my current Sick leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Sick" leave balances displayed in days"<Sick_Available>""<Sick_Pending>""<Sick_Balance>"
  	
  		Examples:
  	|Sick_Available | Sick_Pending  |Sick_Balance|
  	|35.00         |0.00	      |    35.00 | 
  	
  	
 # TODO: Dependency. Not feasible to automate without data setup. 
# Solution: smoke tests to check that fields are present and days properly translated into hours when click on HOURS 		 	
@_Leave
  Scenario Outline: View my current Carer's leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Carer" leave balances displayed in days"<Care_Available>""<Care_Pending>""<Care_Balance>"
  	
  		Examples:
  	|Care_Available | Care_Pending  |Care_Balance|
  	|5.00         |0.00	      |    5.00 | 
  	
  	
# TODO: Dependency. Not feasible to automate without data setup. 
# Solution: smoke tests to check that fields are present and days properly translated into hours when click on HOURS  	
@_Leave
  Scenario Outline: View my current Long Service leave balances
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	And I am on leave page
  	Then I should see my "Long Service" leave balances displayed in days"<LS_Available>""<LS_Pending>""<LS_Balance>"
  	
  		Examples:
  	|LS_Available | LS_Pending  |LS_Balance|
  	|26.60        |0.00	      |    26.60 | 
  	
  	
# TODO: Implement step definitions
 @_to_be_automated
  Scenario: View my current leave balances
  	When I am on a leave page
  	And  I select hours button
  	Then I should see my leave balances displayed in hours
  	
  	
# TODO: Dependency. Not feasible to automate without data setup. 
# Solution:   	Predict twice. Choose latter date and see balance increases.
 @_Leave
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
    |10/11/2017|
 
 
 # TODO: Implement step definitions
 @_to_be_automated
 Scenario: View my leave history
  	When I am on a leave page
  	Then I should see my leave history displayed
  	
# TODO: Dependency. Create leave request if doesn't exist
   @Leave
  	Scenario:  Fixed Term Continuing staff - Delete Pending Leave Request
  	Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I select my pending leave request
  	And I click on Delete button
  	Then I should see Delete success message displayed
  	
  	# TODO: Dependency. Create leave request if doesn't exist as a staff. Login back and continue as a supervisor
 @reg_nonrep
  	 	 Scenario Outline:  Supervisor of fixed term continuing staff - Approve Leave Request
  Given I am on myAurion login page
   	  And I enter username as "uqohoegh"
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
    |06/10/2017    |Approve|
  	
  	
# TODO: Dependency. Create leave request if doesn't exist
  	@reg_nonrep
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
  |04/10/2017    |Reverse|
  	
   	
   	
# TODO: Dependency. Create leave request if doesn't exist
   	  	@Leave
 	 Scenario Outline:   Supervisor of fixed term continuing staff - Decline Leave Request
  Given I am on myAurion login page
   	  And I enter username as "uqohoegh"
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
  |06/10/2017    |Decline|
  
  
# TODO: Dependency. Create leave request if doesn't exist
  @reg_nonrep
Scenario Outline:  Supervisor of fixed term continuing staff - Return Leave Request
Given I am on myAurion login page
   	  And I enter username as "uqohoegh"
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
  |05/10/2017|Return|
   	
   	
# TODO: Dependency. Create leave request if doesn't exist
@reg_nonrep
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
  |05/10/2017|Forward|
   	
  
# TODO: Dependency. Create leave request if doesn't exist
@Leave
Scenario: Fixed Term Continuing staff - Actioning Returned Leave Request (Delete)
  Given I am on myAurion login page
   	  And I enter username as "uqdbende"
      And I enter password as "password123"
      And I click Login button
  	When I am on leave page
  	And I select my pending leave request
  	And I click on Delete button
  	Then I should see Delete success message displayed
   	
   	
#TODO Resolve dependancy: create leave request if doesn't exist already first.
@Leave
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
  	|30/08/2017|30/08/2017|
  
   	
   	
   	
   	
   	
   	 # TODO: Implement step definitions
   	@_to_be_automated
   	 Scenario: View pending leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	
   	 # TODO: Implement step definitions
   @_to_be_automated
  Scenario: View Approved leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Approved" button 
   	Then I should see Approved leave applications in my queue
   	
   	 # TODO: Implement step definitions
   @_to_be_automated
  Scenario: View Cancelled leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Cancelled" button 
   	Then I should see cancelled leave applications in my queue
   	
   	
   	 # TODO: Implement step definitions
   	@_to_be_automated
   	 Scenario: Approve leaves  
  	When I am on MyTasks page
  		And I select Payroll action "Leave Applications"
 		And I click on "Latest" button 
   	Then I should see pending leave applications in my queue
   	
   	 # TODO: Implement step definitions
   		@_to_be_automated
   	 Scenario: View pending leave reversals
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Latest" button 
   	Then I should see pending leave reversals in my queue
   	
   	 # TODO: Implement step definitions
   	
   	@_to_be_automated
  Scenario: View Approved leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Approved" button 
   	Then I should see Approved leave reversals in my queue
   	
   	 # TODO: Implement step definitions
     	@_to_be_automated
  Scenario: View Cancelled leave applications
  	When I am on MyTasks page
  		And I select Payroll action "Leave Reversals"
 		And I click on "Cancelled" button 
   	Then I should see cancelled leave reversals in my queue
   	
   	
   	
   	 
   	
  	

  	
  	
  	