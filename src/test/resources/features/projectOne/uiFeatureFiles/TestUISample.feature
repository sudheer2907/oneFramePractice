@UITestsample
Feature: This is sample UI test.

  Scenario: Test Simple Form Demo page - TextBox testing.
    Given I launch and login to the application
    And I click on tab Input Forms
    And I click on sub tab Simple Form Demo of Input Forms page
    And I enter text message as Sample into enter message textbox
    When I click on button show message
    Then I verify output message is Sample
 
 Scenario: Test Simple Form Demo page - Progress Bars & Sliders.
    Given I launch and login to the application
    And I click on tab Progress Bars
    And I click on sub tab JQuery Download Progress bars of Progress Bars page
    