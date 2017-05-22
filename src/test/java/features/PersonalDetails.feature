@PersonalDetails
Feature: Update Personal Details
As a user/employee
I want to be able to login to the My Aurion system
So that I can view and update my personal details

@Automated
Scenario Outline: Fixed Term Continuing staff - View and update emergency contacts

Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
When I navigate to Personal page
        And I select to Add a new Emrgency contact
        And I Add priority"<Priority>"
        And I Add name"<Name>"
        And I select relatioship"<Relationship>"
        And I select NextofKin Yes or No"<nextofkin>"
        And I add homephone"<HomePhone>"
        And I add mobile"<Mobile>"
        And I add email"<Email>"
		And I add street"<Street>"
		And I select postcode"<PostCode>"
		And I add comments"<Comments>"
		And I click Save button
Then I should see the record successfully saved message displayed"<Name>"

Examples:

|Priority | Name | HomePhone | Mobile | Email | Relationship | Street| PostCode | Comments |nextofkin|
|8		  | Hello| 0797979   | 04123456789 | Hello@mailinator.com | Aunt | My New Street|4074| No Comments at all |Yes|


@Automated
Scenario Outline: View and update emergency contacts- Foreign contacts

Given I am on myAurion login page
   	    And I enter username as "uqdbende"
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
Then I should see the record successfully saved message displayed"<Name>"

Examples:

|Priority | Name | HomePhone | Mobile | Email | Relationship | Street|Town_City|State| PostCode|Country | Comments |
|9		  |Foreign contact| 07979794645   | 04123456789 | Hello.external@mailinator.com | Mother | My New Street|New York|NY|NY2585|USA |No Comments at all here |



@Automated
Scenario Outline: Casual staff - View and update emergency contacts

Given I am on myAurion login page
   	    And I enter username as "uqckel10"
        And I enter password as "password123"
        And I click Login button
When I navigate to Personal page
        And I select to Add a new Emrgency contact
        And I Add priority"<Priority>"
        And I Add name"<Name>"
        And I select relatioship"<Relationship>"
        And I select NextofKin Yes or No"<nextofkin>"
        And I add homephone"<HomePhone>"
        And I add mobile"<Mobile>"
        And I add email"<Email>"
		And I add street"<Street>"
		And I select postcode"<PostCode>"
		And I add comments"<Comments>"
		And I click Save button
Then I should see the record successfully saved message displayed"<Name>"

Examples:

|Priority | Name | HomePhone | Mobile | Email | Relationship | Street| PostCode | Comments |nextofkin|
|11		  | Test User| 0797979   | 04123456789 | Hello@mailinator.com | Aunt | My New Street|4074| No Comments at all |Yes|


@Automated
Scenario Outline: Fixed Term Continuing staff - View and update personal details

Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
When I navigate to Personal page
        And I select to update personal details
        And I Add PreferredName"<PreferredName>"
        And I Add workPhone"<WorkPhone>"
        And I Add Fax"<Fax>"
        And I add homephone"<HomePhone>"
        And I add mobile"<Mobile>"
        And I add email"<Email>"
		And I add street address"<Street>"
		And I select person address postcode"<PostCode>"
		And I select PostAddress Same as Home address
		And I add postnominals"<postnominals>"
		And I click Save button
Then I should see the record successfully updated and saved message displayed"<PreferredName>""<WorkPhone>""<Fax>""<HomePhone>""<Mobile>""<Email>""<PostCode>"

Examples:

|PreferredName | WorkPhone | HomePhone | Mobile      | Email                | Fax     | Street       | PostCode | postnominals |
|Nina		   |464646     | 0797979   | 04123456789 | Hello@mailinator.com |4646464  | My New Street|4000      | XYZ |




Scenario Outline: Fixed Term Continuing staff - View and update staff diversity details

Given I am on myAurion login page
   	    And I enter username as "uqdbende"
        And I enter password as "password123"
        And I click Login button
When I navigate to Personal page
        And I select to update Diversity details
        And I select BirthPlace"<BirthPlace>"
        And I select FirstLanguage"<FirstLanguage>"
        And I select ATSI Status"<ATSI Status>"
        And I select Nationality"<Nationality>"
        And I select Dual Nationality"<Dual Nationality>"
        And I click Save button
Then I should see the record successfully updated and saved message displayed

Examples:

|BirthPlace | FirstLanguage | ATSI Status | Nationality | Dual Nationality |
|USA		  | French |Neither Abor nor Torr Str   | German | 			 |


