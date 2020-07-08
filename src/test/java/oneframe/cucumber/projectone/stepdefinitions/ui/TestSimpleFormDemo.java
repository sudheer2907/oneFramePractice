package oneframe.cucumber.projectone.stepdefinitions.ui;

import com.oneframe.cucumber.projectone.pages.SimpleFormDemoPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSimpleFormDemo {

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

    @And("^I click on tab (.*)$")
    public void i_click_on_tab(String tabNameString) {
        simpleFormDemoPage.clickonTab(tabNameString);
    }

    @And("^I click on sub tab (.*)$")
    public void i_click_on_sub_tab(String subTabNameString) {
        simpleFormDemoPage.clickOnSubtab(subTabNameString);
    }

    @When("^I enter text message as (.*) into enter message textbox$")
    public void i_enter_message_as(String textString) {
        simpleFormDemoPage.enterTextIntoMessageBox(textString);
    }

    @When("^I click on button show message$")
    public void i_click_on_button_show_message() {
        simpleFormDemoPage.clickShowMessageButton();
    }

    @Then("^I verify output message is (.*)$")
    public void i_verify_putput_message_is_sample(String arg) {
        String showMessageOutputString = simpleFormDemoPage.getTextShowMessage();
        System.out.println("Show message output is " + showMessageOutputString);
    }
}
