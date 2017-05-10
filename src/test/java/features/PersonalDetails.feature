@PersonalDetails
Feature: Update Personal Details
As a user/employee
I want to be able to login to the My Aurion system
So that I can view and update my personal details

@rightnow
Scenario Outline: View and update emergency contacts

Given I am on myAurion login page
   	    And I enter username as "uqmsanda"
        And I enter password as "password123"
        And I click Login button
When I navigate to Personal page
        And I select to Add a new Emrgency contact
        And I Add priority"<Priority>"
        And I Add name"<Name>"
        And I select relatioship"<Relationship>"
        And I add homephone"<HomePhone>"
        And I add mobile"<Mobile>"
        And I add email"<Email>"
		And I add street"<Street>"
		And I select postcode"<PostCode>"
		And I add comments"<Comments>"
		And I click Save button
Then I should see the record successfully saved message displayed

Examples:

|Priority | Name | HomePhone | Mobile | Email | Relationship | Street| PostCode | Comments |
|6		  | Hello| 0797979   | 04123456789 | Hello@mailinator.com | Aunt | My New Street|4074| No Comments at all |


@rightnow
Scenario Outline: View and update emergency contacts- Foreign contacts

Given I am on myAurion login page
   	    And I enter username as "uqmsanda"
        And I enter password as "password123"
        And I click Login button
When I navigate to Personal page
        And I select to Add a new Emrgency contact
        And I Add priority"<Priority>"
        And I Add name"<Name>"
        And I add homephone"<HomePhone>"
        And I add mobile"<Mobile>"
        And I add email"<Email>"
		And I select relatioship"<Relationship>"
		And I add street"<Street>"
		And I add city"<Town_City>"
		And I add state"<State>"
		And I select postcode"<PostCode>"
		And I select country"<Country>"
		And I add comments"<Comments>"
		And I click Save button
Then I should see the record successfully saved message displayed

Examples:

|Priority | Name | HomePhone | Mobile | Email | Relationship | Street|Town_City|State| PostCode|Country | Comments |
|3		  |Foreign contact| 07979794645   | 04123456789 | Hello.external@mailinator.com | Mother | My New Street|New York|NY|NY2585|USA |No Comments at all here |

