package oneframe.cucumber.stepdefinitions.seleniumeasy;

import org.testng.Assert;

import com.oneframe.cucumber.projectone.pages.HomePage;
import com.oneframe.cucumber.projectone.pages.ProgressBars;
import com.oneframe.cucumber.projectone.pages.SimpleFormDemoPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSimpleFormDemo {

    SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();
    HomePage homePage = new HomePage();
    ProgressBars progressBars = new ProgressBars();

    @And("^I click on tab (.*)$")
    public void i_click_on_tab(String tabNameString) throws Exception {
        System.out.println("tabNameString is " + tabNameString);
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
            String showMessageOutputString = simpleFormDemoPage.getTextShowMessage();
            System.out.println("Show message output is " + showMessageOutputString);
            break;
        case "double":
            simpleFormDemoPage.clickGetTotalValue();
            String getTotalValue = simpleFormDemoPage.getTotalValueText();
            System.out.println("Show message output is " + getTotalValue);
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
        System.out.println(simpleFormDemoPage.getCheckBoxSelectedMessage());
    }
}
