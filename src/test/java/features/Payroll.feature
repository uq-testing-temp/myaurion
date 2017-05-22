@Payroll
Feature: Payroll
As a user
I want to be able to login to the My Aurion system
So that I can update my payroll details



#Background:
 #   Given I am on myAurion login page
  # 	  And I enter username as "uqmsanda"
   #   And I enter password as "password123"
    #  And I click Login button

 
 
 Scenario: View current bank account
 	When I am on Payroll page
 	And I select Payroll action "Accounts and Deductions"
 	Then I should see my current bank accounts
 	
 	

 Scenario Outline: Update current bank account
 When I am on Payroll page
 	And I select Payroll action "Accounts and Deductions"
 	And I select the current bank account "<AccountNumber>"
 	And I select branch "<Branch>"
 	And I add account number "<AccountNumber>"
 	And I add payee "<Payee>"
 	And I click on Save button
 Then I should see the success message is displayed
 
 Examples:
  | AccountNumber | Branch    | AccountNumber |Payee |
  
  
  
  Scenario Outline: Add secondary bank account
 When I am on Payroll page
 	And I select Payroll action "Accounts and Deductions"
 	And I click on "New account" button
 	And I enter bank account number "<AccountNumber>"
 	And I select branch "<Branch>"
 	And I add account number "<AccountNumber>"
 	And I add payee "<Payee>"
 	And I add normal amount "<Normal Amount>"
 	And I select Start at "<Start at>"
 	And I click on Save button
 Then I should see the success message is displayed
 
 Examples:
  | AccountNumber | Branch    | AccountNumber |Payee |Normal Amount |Start at |
  
  
  
  
   Scenario Outline: Add Deduction
 When I am on Payroll page
 	And I select Payroll action "Accounts and Deductions"
 	And I click on "New deduction" button
 	And I select deduction "<Deduction>"
 	And I add referencenumber "<RefNumber>"
 	And I add normal amount "<Normal Amount>"
 	And I select Start at "<Start at>"
 	And I click on Save button
 Then I should see the success message "Deduction" is displayed
 
 Examples:
  | Deduction | RefNumber| Normal Amount |Start at |
  
  
  
    Scenario Outline: Update Deduction
 When I am on Payroll page
 	And I select Payroll action "Accounts and Deductions"
 	And I select current deduction "<Current deduction>"
 	And I add next pay amount "<NextPay Amount>"
 	And I click on Save button
 Then I should see the success message "Deduction" is displayed
 
 Examples:
  |Current deduction| NextPay Amount |
  
  
  
    Scenario Outline: Update Deduction stop Payment
 When I am on Payroll page
 	And I select Payroll action "Accounts and Deductions"
 	And I select current deduction "<Current deduction>"
 	And I add next pay amount "<NextPay Amount>"
 	And I select stop reason "<Stop Reason>"
 	And I click on Save button
 Then I should see the success message "Deduction" is displayed
 
 Examples:
  |Current deduction| NextPay Amount |Stop Reason|
  
  
  
   Scenario: View PaySummaries
Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
 When I am on Payroll page
 	And I select Payroll action "Pay Summaries"
 Then I should see my current pay summaries
 
 
 @Automated
   Scenario Outline: Fixed Term Continuing staff - View pay details and pay advices
Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
 When I am on Payroll page
 	And I select Payroll action "Pay Summaries"
 	And I select the summary for date"<Date>"
 Then I should see my pay summary details"<GrossPayAmount>"and"<NetPayAmount>"
 
 Examples:
  |Date|GrossPayAmount|NetPayAmount|
  |25/05/2016|3,257.49 |2,449.49 |
  
 
 @Automated
    Scenario Outline: Fixed Term Continuing staff - View year to date for current or previous financial year
 Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
 When I am on Payroll page
 	And I select Payroll action "Year to Date"
 	And I select "<current_previous>" year summary 
 Then I should see my year to date summary details
 
 Examples:
  |current_previous|
  |current year|
  |previous year|
  
  
  
    Scenario Outline: View Remuneration information
 When I am on the payroll page
 	And I select Payroll action "Remuneration Information"
 	And I select View Remuneration Information
 	And I Enter calculation date "<Calculation date>"
 	And I click on "Go »" button
 Then I should see my Remuneration Information details
 
 Examples:
  |Calculation date|
  |02 May 2015|
  
 @Automated
  Scenario Outline: Fixed Term Continuing staff - Access ATO Payment Summary
Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
 When I am on Payroll page
 	And I select Payroll action "ATO Payment Summaries"
 Then I should see summary pdf download link for date"<Date>"
 
 
  Examples:
  |Date|
  |30/06/2015|
  
  
   @Automated 
  Scenario Outline: Casual staff - Access ATO Payment Summary
Given I am on myAurion login page
   	    And I enter username as "uqckel10"
        And I enter password as "password123"
        And I click Login button
 When I am on Payroll page
 	And I select Payroll action "ATO Payment Summaries"
 Then I should see summary pdf download link for date"<Date>"
 
 
  Examples:
  |Date|
  |30/06/2016|
 
 
 
 
  
  
  
  
  
  