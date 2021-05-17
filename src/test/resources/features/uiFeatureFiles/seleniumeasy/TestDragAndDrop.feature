@TestUI
@TestDragAndDrop
Feature: Test Drag and Drop Module.

  Scenario: 01 Test Drag and Drop Page
    Given I launch and login to the application
    And I click on tab Progress Bars
    And I click on sub tab Drag & Drop of progress bars page
    When I move the first slider value to 20