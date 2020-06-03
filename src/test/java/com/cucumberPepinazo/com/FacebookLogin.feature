Feature: Facebook Login

Scenario: Login button exists

	Given I have open the browser
	
	When I open Facebook website
	
	Then Login button should exist
	
Scenario: User cannot log into facebook without credentials

	Given I have open the browser
	
	When I open Facebook website
	
	And I click the login button
	
	Then Facebook asks me to enter credentials
	
Scenario: I login using cell phone number

	Given I have open the browser
	
	When I open Facebook website
	
	And I login using cell phone number
	
	Then I can see Home Page
	
	And I logout the session
	

        
        
	