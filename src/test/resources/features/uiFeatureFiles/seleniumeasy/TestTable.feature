@TestUI
@TestTable
Feature: Test table.

@inp
Scenario: Test Rows and column of table
    Given I launch and login to the application
    And I click on tab Table
    And I click on sub tab Table Pagination of Table page
    Then I verify table pagination page is loaded
    Then I verify first table page have five rows
    Then I verify first page of table have five ids starting from 1 to 5

Scenario: Test first row data of the table
    Given I launch and login to the application
    And I click on tab Table
    And I click on sub tab Table Pagination of Table page
    Then I verify table pagination page is loaded
    Then I verify 1 row data
    Then I verify 2 row data
    Then I verify 3 row data
