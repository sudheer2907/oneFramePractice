package oneframe.cucumber.stepdefinitions.seleniumeasy;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.oneframe.cucumber.projectone.seleniumeasypages.HomePage;
import com.oneframe.cucumber.projectone.seleniumeasypages.ProgressBars;
import com.oneframe.cucumber.projectone.seleniumeasypages.SimpleFormDemoPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSimpleFormDemo {

  SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();
  HomePage homePage = new HomePage();
  ProgressBars progressBars = new ProgressBars();

  @And("^I click on tab (.*)$")
  public void i_click_on_tab(String tabNameString) throws Exception {
    homePage.clickonTab(tabNameString);
  }

  @And("^I click on sub tab (.*) of Input Forms page$")
  public void i_click_on_sub_tab(String subTabNameString) throws Exception {
    switch (subTabNameString) {
      case "Simple Form Demo":
        simpleFormDemoPage.clickOnSubtab(subTabNameString);
        break;
      case "Checkbox Demo":
        simpleFormDemoPage.clickOnSubtab(subTabNameString);
        break;
      case "Radio Buttons Demo":
        simpleFormDemoPage.clickOnSubtab(subTabNameString);
        break;
    }
  }

  @When("^I enter text message as (.*) into (.*) textbox$")
  public void i_enter_message_as(String textString, String textBoxName) throws Exception {
    switch (textBoxName) {
      case "enterMessage":
        simpleFormDemoPage.enterTextIntoEnterMessageTextBox(textString);
        break;
      case "enterA":
        simpleFormDemoPage.enterTextIntoEnterATextBox(textString);
        break;
      case "enterB":
        simpleFormDemoPage.enterTextIntoEnterBTextBox(textString);
        break;
      default:
        Assert.fail("Wrong text box value found");
        break;
    }
  }

  @When("^I click on button show message$")
  public void i_click_on_button_show_message() throws Exception {
    simpleFormDemoPage.clickShowMessageButton();
  }

  @Then("^I verify output message (.*) input textbox is (.*)$")
  public void i_verify_putput_message_is_sample(String arg1, String arg2) throws Exception {
    switch (arg1) {
      case "single":
        Assert.assertTrue(simpleFormDemoPage.getTextShowMessage().equalsIgnoreCase(arg2),
            "Textbox Output message is not verified, Expected message:" + arg2 + " Found:"
                + simpleFormDemoPage.getTextShowMessage());
        break;
      case "double":
        simpleFormDemoPage.clickGetTotalValue();
        Assert.assertTrue(simpleFormDemoPage.getTotalValueText().equalsIgnoreCase(arg2),
            "Get Total Value is not verified, Expected message:" + arg2 + " Found:"
                + simpleFormDemoPage.getTotalValueText());
        break;
      default:
        Assert.fail("Wrong text box value found");
        break;
    }
  }

  @And("^I click on the checkbox (.*)$")
  public void i_click_on_the_checkbox(String checkBoxName) throws Exception {
    switch (checkBoxName) {
      case "Click on this check box":
        simpleFormDemoPage.clickClickOnthIsCheckBox();
        break;
      default:
        break;
    }
  }

  @Then("^I verify Success - Check box is checked message is displayed$")
  public void i_verify_checkboxMessage() {
    Assert.assertTrue(
        simpleFormDemoPage.getCheckBoxSelectedMessage()
            .equalsIgnoreCase("Success - Check box is checked"),
        "Message displayed after clicking Checkbox is not correct");
  }

  @And("^I select gender as (.*) radio button under section (.*)$")
  public void i_select_gender(String genderString, String sectionName) throws Exception {
    switch (sectionName) {
      case "Radio Button Demo":
        simpleFormDemoPage.selectGenderUnderRadioButtonDemo("Male");
        TimeUnit.SECONDS.sleep(10);
        break;
      case "Group Radio Buttons Demo":
        simpleFormDemoPage.selectGenderUnderGroupRadioButtonDemo("Male");
        TimeUnit.SECONDS.sleep(10);
        break;
      default:
        break;
    }
  }

  @When("^I click on get checked value button$")
  public void i_click_on_get_checked_value_button() {
    simpleFormDemoPage.clickGetValueButton();
  }

  @Then("^I verify output message displayed as Radio button 'Male' is checked$")
  public void i_verify_output_message_displayed_as_radio_button() {
    Assert.assertTrue(
        simpleFormDemoPage.getResultAfterClickingGetCheckedValues()
            .equalsIgnoreCase("Radio button 'Male' is checked"),
        "Message displayed after clicking get values button is not correct");
  }
}
