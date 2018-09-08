Feature: Google news search

@FirstScenario
Scenario: News search for TCS
	Given I am on google homepage
	When I search for 'TCS'
	And I open News tab
	Then I should see images displayed
	
Scenario: News search for CitiusTech
	Given I am on google homepage
	When I search for 'CitiusTech'
	And I open News tab
	Then I should see images displayed

@LastScenario
Scenario: News search for Google
	Given I am on google homepage
	When I search for 'Google'
	And I open News tab
	Then I should see images displayed