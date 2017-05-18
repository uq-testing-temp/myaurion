@StaffSchedule
Feature: StaffSchedule
  As a supervisor
  I want to be able to login to the My Aurion system
  So that I can run and view the staff schedule
  
  
  Scenario Outline: Supervisor of fixed term continuing staff - Run staff schedule
   Given I am on myAurion login page
   	  And I enter username as "uqmblows"
      And I enter password as "password123"
      And I click Login button
  	When I am on Staff Schedule page
  	And I select the start date"<StartDate>"
  	And I select Employee"<Employee>"
  	And I select organisation unit"<Org_unit>"
  	And I select include sub units"<sub units>"
  	And I select payment type"<payment_type>"
  	And I enter Exclude Job Category as "<ExcludeJobCategory>"
  	And I enter Exclude employee Category as "<ExcludeempCategory>"
  	And I click view schedule button
  	Then I should see the  staff schedule displayed for the "<Employee>"
  	
  	
  	Examples:
  	|StartDate|Employee |Org_unit|sub units|payment_type|
  	