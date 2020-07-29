Feature: Auth token API tests

Scenario: Verify auth token is generated for valid credentials
Given Auth - CreateToken end point is setup
When Auth - CreateToken payload is created
And Auth - CreateToken end point is hit
Then a valid token should be generated

    
    
   