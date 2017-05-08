@PersonalDetails
Feature: Update Personal Details
As a user/employee
I want to be able to login to the My Aurion system
So that I can view and update my personal details

@now
Scenario Outline: View and update emergency contacts

Given I am on myAurion login page
   	    And I enter username as "uqmsanda"
        And I enter password as "password123"
        And I click Login button
When I navigate to Personal page
        And I select to Add a new Emrgency contact
        And I Add <"Priority">
        And I Add <"Name">
        And I add <"HomePhone">
        And I add <"Mobile">
        And I add <"Email">
		And I select <"Relationship">
		And I add <"Street">
		And I add <"Town_City">
		And I add <"State">
		And I select <"PostCode">
		And I select <"Country">
		And I add <"Comments">
		And I click Save button
Then I should see the record successfully saved message displayed

Examples:

|Priority | Name | HomePhone | Mobile | Email | Relationship | Street| Postcode | Comments |
|3		  | Hello | 0797979 | 04123456789 | Hello@mailinator.com | Uncle | My New Street| 4101 | No Comments at all |
