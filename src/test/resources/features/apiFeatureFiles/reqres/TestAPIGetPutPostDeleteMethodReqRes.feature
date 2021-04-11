@TestAPI
Feature: This is sample feature file to test GET method 

Scenario: Test GET LIST USERS 
    Given I hit the GET method to get list of users 
    Then I verify the list of user details are correct 
    
Scenario: Test GET SINGLE USERS 
    Given I hit the GET method to get single users 
    Then I verify the single users details are correct 
    
Scenario: Test POST Create user 
    Given I hit the POST method to create an user 
    Then I verify the user is created