package oneframe.cucumber.stepdefinitions.seleniumeasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;

import com.oneframe.cucumber.projectone.seleniumeasypages.ListBox;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestListBoxPage {

  ListBox listBox = new ListBox();

  @And("^I click on sub tab (.*) of List Box Page$")
  public void i_click_on_sub_tab_table_pagination_of_table_page(String subTabName) {
    listBox.clickOnSubtab(subTabName);
  }

  @Then("^I select (.*) from left side list box$")
  public void i_select_list(String listToBeSelected) {
    listBox.selectOptionFromLeftList(listToBeSelected);
  }

  @Then("^I click (.*) Arrow button$")
  public void i_click_on_arrow_button(String arrowButtonName) {
    listBox.clickArrowButton(arrowButtonName);
  }

  @Then("^I verify list of option on the right side$")
  public void i_verify_list_of_options_on_the_right_side() {
    Assert.assertTrue(listBox.getRightSideOpionsOfList().contains("bootstrap-duallist"));
    Assert.assertTrue(listBox.getRightSideOpionsOfList().contains("Porta ac consectetur ac"));
    Assert.assertTrue(listBox.getRightSideOpionsOfList().contains("Morbi leo risus"));
  }

  @When("^I enter (.*) into the right side search box$")
  public void i_search_into_right_side(String textName) {
    listBox.searchIntoRightSide(textName);
  }

  @Then("^I verify searched options is displayed as (.*) into right side list$")
  public void i_verify_searched_options_into_right_side(String input) {
    Assert.assertTrue(listBox.getFirstOptionsFromRightSideOpions().equalsIgnoreCase(input));
  }

  @And("^I selected (.*),(.*),(.*) from a JQuery List box$")
  public void i_selected_multiple_dropdown_options(String value1, String value2, String value3)
      throws InterruptedException {
    List<String> list = new ArrayList<>();
    list.add(value1);
    list.add(value2);
    list.add(value3);
    listBox.selectMulitpleOptionFromJqueryListBox(list);
  }

  @And("^I click on the button (.*) to select Jquery list$")
  public void i_click_on_add_button_to_select_jquery_list(String buttonName) {
    listBox.clickButton(buttonName);
  }

  @Then("^I verify Jquery options are selected as (.*),(.*),(.*)$")
  public void i_verify_jquery_options_are_selected(String value1, String value2, String value3) {
    List<String> expectedList = new LinkedList<>();
    expectedList.add(value1);
    expectedList.add(value2);
    expectedList.add(value3);
    List<String> fetchedList = listBox.getListOfJqueryselectedList();
    Collections.sort(expectedList);
    Collections.sort(fetchedList);
    Assert.assertTrue(expectedList.equals(fetchedList));
  }
}
