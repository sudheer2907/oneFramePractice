@TestUI
@TestAlertsAndModals
Feature: Test Alerts and Modals.

Scenario: 01 Test bootstrap alerts.
   Given I launch and login to the application
   And I click on tab Alerts & Modals
   And I click on sub tab Bootstrap Alerts of Alerts and modals page
   When I click on Autocloseable success button
   Then I verify Autocloseable success message is displayed
   When I click on Normal success button
   Then I verify Normal success message is displayed
   When I click on Normal Info button
   Then I verify Normal Info message is displayed
   Then I close normal info message alerts

Scenario: 02 Test Bootstrap Modals with Single Modal Example
 	 Given I launch and login to the application
   And I click on tab Alerts & Modals
 	 And I click on sub tab Bootstrap Modals of Alerts and modals page
 	 And I click on launch model button of Single Mode
 	 Then I verify Single Modal alert is opened
 	 Then I close Single Modal alert

Scenario: 03 Test Bootstrap Modals with Multiple Modal Example
 	 Given I launch and login to the application
   And I click on tab Alerts & Modals
 	 And I click on sub tab Bootstrap Modals of Alerts and modals page
 	 And I click on launch model button of Multiple Mode
 	 Then I verify Multiple Modal alert is opened
 	 Then I close Multiple Modal alert

Scenario: 04 Test Java Scripts Alerts
 	 Given I launch and login to the application
   And I click on tab Alerts & Modals
 	 And I click on sub tab Javascript Alerts of Alerts and modals page
 	 When I click on alert button alertJavaScript1
 	 Then I verify Java Script alert box is opened
 	 When I click on alert button alertJavaScript2
 	 Then I verify Java Script alert box is opened
 	 When I click on alert button alertJavaScript3
 	 And I enter some text into alert box and close the alert