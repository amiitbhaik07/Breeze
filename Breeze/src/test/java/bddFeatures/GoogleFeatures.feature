Feature: Google image search

@FirstScenario
Scenario: Image search for TCS
	Given I am on google homepage
	When I search for 'TCS'
	And I open Images tab
	Then I should see images displayed

Scenario: Image search for CitiusTech
	Given I am on google homepage
	When I search for 'CitiusTech'
	And I open Images tab
	Then I should see images displayed

@LastScenario
Scenario: Image search for Google
	Given I am on google homepage
	When I search for 'Google'
	And I open Images tab
	Then I should see images displayed