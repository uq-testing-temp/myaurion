@healthcheck
Feature: Health check
	
	Scenario: Make sure environmental variable is present
	 Given I get the environment from the environmental variable
	 
	Scenario: Make sure environment is up and running
	 Then I am on myAurion login page
	 
	 @debug
	Scenario: Make sure screenshots are working
	 Then I am able to take screenshots


