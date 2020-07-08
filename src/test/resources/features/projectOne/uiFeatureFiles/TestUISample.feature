@UITestsample
Feature: This is sample UI test.

  Scenario: Test Simple Form Demo page.
    Given I launch and login to the application
    And I click on tab Input Forms
    And I click on sub tab Simple Form Demo
    And I enter text message as Sample into enter message textbox
    When I click on button show message
    Then I verify output message is Sample
