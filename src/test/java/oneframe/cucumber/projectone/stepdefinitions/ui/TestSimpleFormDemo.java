package oneframe.cucumber.projectone.stepdefinitions.ui;

import com.oneframe.cucumber.projectone.pages.SimpleFormDemoPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSimpleFormDemo {

    SimpleFormDemoPage SimpleFormDemoPageObj = new SimpleFormDemoPage();

    @And("^I click on tab (.*)$")
    public void i_click_on_tab(String tabNameString) {
        SimpleFormDemoPageObj.clickonTab(tabNameString);
    }

    @And("^I click on sub tab (.*)$")
    public void i_click_on_sub_tab(String subTabNameString) {
        SimpleFormDemoPageObj.clickOnSubtab(subTabNameString);
    }

    @When("^I enter text message as (.*)$")
    public void i_enter_message_as(String textString) {

    }

    @Then("^I verify out is (.*)$")
    public void i_verify_out_is(String messageText) {

    }
}
