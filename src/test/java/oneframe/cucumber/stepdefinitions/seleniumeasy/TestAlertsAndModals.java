package oneframe.cucumber.stepdefinitions.seleniumeasy;

import org.testng.Assert;

import com.oneframe.cucumber.projectone.seleniumeasypages.AlertsAndModals;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestAlertsAndModals {

  AlertsAndModals alertsAndModals = new AlertsAndModals();

  @And("^I click on sub tab (.*) of Alerts and modals page$")
  public void i_click_on_subtab_bootstrap(String str) {
    alertsAndModals.clickOnSubTab(str);
  }

  @When("^I click on (.*) button$")
  public void i_click_on_bootstarp_button(String buttonName) {
    alertsAndModals.clickOnBootStrapbutton(buttonName);
  }

  @Then("^I verify (.*) message is displayed$")
  public void i_verify_displayed_message(String expMessageFor) {
    switch (expMessageFor) {
      case "Autocloseable success":
        String messageFetched = alertsAndModals.getMessage(expMessageFor);
        System.out.println("1:::" + messageFetched);
        Assert.assertEquals("I'm an autocloseable success message. I will hide in 5 seconds.",
            messageFetched);
        break;
      case "Normal success":
        String messageFetched2 = alertsAndModals.getMessage(expMessageFor);
        System.out.println("2:::" + messageFetched2);
        Assert.assertEquals("I'm a normal success message. To close use the appropriate button.",
            messageFetched2);
        break;
      case "Normal Info":
        String messageFetched3 = alertsAndModals.getMessage(expMessageFor);
        System.out.println("3:::" + messageFetched3);
        Assert.assertEquals("I'm a normal info message. To close use the appropriate button.",
            messageFetched3);
        break;
      default:
        Assert.fail("Wrong Sub tab name is provided.");
    }
  }

  @Then("^I close normal info message alerts$")
  public void i_close_normal_info_message_alerts() {
    alertsAndModals.closeNormalInfoAlerts();
  }

  @And("^I click on launch model button of (.*)$")
  public void i_click_on_launch_model_button(String buttonName) {
    alertsAndModals.clickLaunchButton(buttonName);
  }

  @Then("^I verify Single Modal alert is opened$")
  public void i_verify_single_modal_alert_is_opened() throws InterruptedException {
    Assert.assertTrue(alertsAndModals.isSingleModelExamplePopUpDisplayed());
  }

  @Then("^I verify Multiple Modal alert is opened$")
  public void i_verify_multiple_modal_alert_is_opened() {
    Assert.assertTrue(alertsAndModals.isMultipleModelExamplePopUpDisplayed());
  }

  @Then("^I close (.*) Modal alert$")
  public void i_close_single_modal_alert(String popUpName) {
    alertsAndModals.closeSingleModePopUp(popUpName);
  }

  @When("^I click on alert button (.*)$")
  public void i_click_on_js_alert_box(String jsAlertName) {
    alertsAndModals.clickJavaScriptAlert(jsAlertName);
  }

  @Then("^I verify Java Script alert box is opened$")
  public void i_verify_js_alertbox_is_opened() {
    String alertNameString = alertsAndModals.getAlertName();
    System.out.println("Alert Name::" + alertNameString);
    Assert.assertTrue(alertNameString != null);
    alertsAndModals.closeAlert();
  }

  @And("^I enter some text into alert box and close the alert$")
  public void i_enter_some_text_into_alert_box_and_close_the_alert() {
    alertsAndModals.enterTextIntoAlertBoxAndCloseTheAalert();
    System.out.println("Text is entered into Alert Box");
  }
}
