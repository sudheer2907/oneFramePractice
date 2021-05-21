@TestUI
@TestOthers
Feature: Test Others tab.

  @inp
  Scenario: Test Rows and column of table
    Given I launch and login to the application
    And I click on tab Others
    And I click on sub tab Drag and Drop of others page
    And I drag Draggable 1 to target position