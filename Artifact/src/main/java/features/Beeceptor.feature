
Feature: Beeceptor test

	Background:
		

	@runapi
  Scenario: GetRequest test
	  Given Get the end point url 'https://echo.free.beeceptor.com/sample-request?author=beeceptor'
    Then Validate Success response 
    Then Validate the path as '/sample-request'
    Then Validate the ip as '183.82.24.213'
    
	@runapi
  Scenario: PostRequest test
	  Given Post the end point url 'https://echo.free.beeceptor.com/sample-request?author=beeceptor'
    Then Validate Success response 
    Then Validate the customer name as 'Jane Smith'
    Then Validate the customer email as 'janesmith@example.com'
    Then Validate the payment amount as '79.99'
    

