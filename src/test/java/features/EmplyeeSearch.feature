@EmployeeSearch
Feature: Employee Search
As a supervisor
I want to be able to login to the My Aurion system
So that I can search for and change employee to view my subordinates details


#Background:
 #   Given I am on myAurion login page
  # 	  And I enter username as "uqmsanda"
   #   And I enter password as "password123"
    #  And I click Login button
      
  @Automated    
 Scenario Outline: Search for direct reports
 
 
 Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
Then I should see the matching search result"<EmployeeToSelect>"

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea    |BENDER-CHAMP, Dorothea|
 
 
 
 
 
 
  @Automated    
 Scenario Outline: Supervisor - view subordinate's details
 
 
 Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
Then I should see the details of the selected user"<EmployeeToSelect>"

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea      |BENDER-CHAMP, Dorothea|
 
 
 
  @Automated    
 Scenario Outline: Supervisor - Try to view subordinate's Payroll details
 
 
 Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And I am on Payroll page
Then I should see No access error message displayed

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea     |BENDER-CHAMP, Dorothea|
 
 
   @Automated    
 Scenario Outline: Supervisor - Try to view subordinate's Personal details
 
 
 Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And I navigate to Personal page
Then I should see No access error message displayed

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea   |BENDER-CHAMP, Dorothea|
 
 
 
 
  Scenario Outline: Search for indirect reports
 
 When I am on the DashboardPage
 	And I click on change Employee icon
 	And I enter the employee search phrase "<EmployeeSearchPhrase>"
Then I should see the matching search result "<EmployeeToSelect>"

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |	    |   |
 
 @Automated
 Scenario: Search for employees- No results found
 
Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"XYZ"
Then I should see the No results found message


 
 
 Scenario Outline: Search for direct reports and act on behalf of employee
 
 When I am on the DashboardPage
 	And I click on change Employee icon
 	And I enter the employee search phrase "<EmployeeSearchPhrase>"
 	And I select the employee from search results "<EmployeeToSelect>"
 Then I should see the current user as selected employee "<EmployeeToSelect>"

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea               | BENDER-CHAMP, Dorothea   |
  |2037164            | ASGARI, Sassan    |
  
 
 Scenario Outline: Act on behalf of employee and navigate to Payroll
 
 When I am on the Payroll page
 	And I click on change Employee icon
 	And I enter the employee search phrase "<EmployeeSearchPhrase>"
 	And I select the employee from search results "<EmployeeToSelect>"
 Then I should see the No access error message
 

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |heidi e               | heidi ellis     |
  |2004378             | AMY, Wendy J    |
  
   
Scenario Outline: Act on behalf of employee and navigate to personal details
 
 When I am on the Personal details page
 	And I click on change Employee icon
 	And I enter the employee search phrase "<EmployeeSearchPhrase>"
 	And I select the employee from search results "<EmployeeToSelect>"
 Then I should see the No access error message
 

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |heidi e               | heidi ellis     |
  |2004378             | AMY, Wendy J    |
  
  
  
  
  @Automated
  Scenario Outline: Supervisor of fixed term continuing staff - MyStaff view details
 
 Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And I navigate to HR Profile page
Then I should be able to see the Qualifications,Licences and Inductions details

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea      |BENDER-CHAMP, Dorothea|
 
 
 
 @Automated
  Scenario Outline: Supervisor of casual staff - MyStaff view details
 
 Given I am on myAurion login page
   	    And I enter username as "uqmverre"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And I navigate to HR Profile page
Then I should be able to see the Qualifications,Licences and Inductions details

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |KELLY, Caroline H      |KELLY, Caroline H|
 
 
 
 
  Scenario Outline: Supervisor of fixed term continuing staff - MyStaff view training history
 
 Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And I am on the Training courses page
Then I should be able to see the Training History details

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea      |BENDER-CHAMP, Dorothea|


@Automated
  Scenario Outline: Supervisor of fixed term continuing staff - MyStaff leave
 
 Given I am on myAurion login page
   	    And I enter username as "uqsdove "
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And  I am on leave page
 		And I enter a future date"<futuredate>"
 		And I click on the Predict button
 	Then I should see my predicted leave balances displayed

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect| Future Date|
 |BENDER-CHAMP, Dorothea      |BENDER-CHAMP, Dorothea| 21/11/2017|
 


 
  Scenario Outline:  Supervisor of fixed term continuing staff - MyStaff view employment
 
 Given I am on myAurion login page
   	    And I enter username as "uqmblows"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And I am on Employment History page
		And I select the current acting active placement
 	Then I should see my current acting active placement details

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |BENDER-CHAMP, Dorothea      |BENDER-CHAMP, Dorothea|
 
 
 Scenario Outline:  Supervisor of casual staff - MyStaff view employment
 
 Given I am on myAurion login page
   	    And I enter username as "uqmverre"
        And I enter password as "password123"
        And I click Login button
 		And I click on change Employee icon
 		And I enter the employee search phrase"<EmployeeSearchPhrase>"
 		And I select the employee from search results"<EmployeeToSelect>"
 		And I am on Employment History page
		And I select the current acting active placement
 	Then I should see my current acting active placement details

Examples:
 | EmployeeSearchPhrase | EmployeeToSelect|
 |GILLESPIE, Alison M     |GILLESPIE, Alison M|
 