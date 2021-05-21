@TestUI
@TestListBox
Feature: Test List Box.

Scenario Outline: 01 Test Bootstrap List Box
    Given I launch and login to the application
    And I click on tab List Box
    And I click on sub tab Bootstrap List Box of List Box Page
    And I select <value1> from left side list box
    And I select <value2> from left side list box
    And I select <value3> from left side list box
    Then I click Right Arrow button
    Then I verify list of option on the right side
    When I enter <value1> into the right side search box
    Then I verify searched options is displayed as <value1> into right side list

    Examples:
    |value1             |value2                  |value3          |
    |bootstrap-duallist |Porta ac consectetur ac |Morbi leo risus |

Scenario Outline: 02 Test JQuery List Box
    Given I launch and login to the application
    And I click on tab List Box
    And I click on sub tab JQuery List Box of List Box Page
    And I selected <value1>,<value2>,<value3> from a JQuery List box
    And I click on the button <buttonName> to select Jquery list
    Then I verify Jquery options are selected as <value1>,<value2>,<value3>

    Examples:
    |value1   |value2 |value3 |buttonName |
    |Isabella |Sophia |Alice 	|Add        |

Scenario Outline: 03 Test Data List Filter
    Given I launch and login to the application
    And I click on tab List Box
    And I click on sub tab Data List Filter of List Box Page
    When I serached <searchedName> into Data List filter serach box
    Then I verify <searchedName> is displayed as a result
    
    Examples:
    |searchedName |
    |Manager      |