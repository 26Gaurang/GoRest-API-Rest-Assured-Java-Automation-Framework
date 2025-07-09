Feature: GoRest API - CRUD operations 




Scenario Outline: Create, Retrieve, Modify & Delete User 
	Given I create a user using POST Request with "<name>", "<email>", "<gender>", "<status>"
	When I retrieve user details using GET Request
	And I modify user using PATCH Request with "<PatchField>" field and "<PatchValue>" value
	And I remove the user using DELETE Request
	Then I try to retrieve user details using GET Request

Examples:
|name				|	|email        |	|gender|	|status	 |	|PatchField	 |	|PatchValue			|
|Sansa Stark|	|sansa@got.com|	|female|	|active  |	|name				 |	|Sansa Lannister|
|Jon Snow   |	|jon@got.com  |	|Male  |	|active  |	|status			 |	|inactive				|
|Brann Stark|	|brann@got.com|	|Male  |	|inactive|	|email			 |	|raven3@got.com	|


#POST
#	Scenario: Create a User 
#	Given I create a user using POST Request
	
#GET	
#	Scenario: Create and Retrieve User Details 
#	Given I create a user using POST Request
#	When I retrieve user details using GET Request
	
#PATCH	
#	Scenario: Create and Modify User Details 
#	Given I create a user using POST Request
#	When I modify user name using PATCH Request
	
#DELETE	
#	Scenario: Create and Delete User Details 
#	Given I create a user using POST Request
#	When I remove the user using DELETE Request
#	Then I try to retrieve user details using GET Request



