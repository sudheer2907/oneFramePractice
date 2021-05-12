package oneframe.cucumber.stepdefinitions.seleniumeasy;

import com.oneframe.cucumber.projectone.seleniumeasypages.TablePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;

public class TestTablePage {

  TablePage tablePage = new TablePage();

  @And("^I click on sub tab (.*) of Table page$")
  public void i_click_on_sub_tab_table_pagination_of_table_page(String subTabName) {
    tablePage.clickOnSubTab(subTabName);
  }

  @Then("^I verify table pagination page is loaded$")
  public void i_verify_table_pagination_page_is_loaded() {
    Assert.assertTrue(tablePage.isTablePaginationPageLoaded());
  }

  @Then("^I verify first table page have five rows$")
  public void i_verify_firts_table_page_have_five_rows() {
    Assert.assertTrue(tablePage.getTableRowSize()==5);
  }

  @Then("^I verify first page of table have five ids starting from 1 to 5$")
  public void i_verify_firts_page_of_table_have_five_ids() {
  List<Integer> list = tablePage.getListOfIds();
  List<Integer> expList = new ArrayList<>();
  expList.add(1);
  expList.add(2);
  expList.add(3);
  expList.add(4);
  expList.add(5);
  Collections.sort(expList);
  Collections.sort(list);
  Assert.assertTrue(expList.equals(list));
  }

  @Then("^I verify (.*) row data$")
  public void i_verify_first_row_data(int rowNum) {
    System.out.println((tablePage.getTableRowData(rowNum).toString()));
    Assert.assertTrue(tablePage.getTableRowData(rowNum).get(0).equalsIgnoreCase(String.valueOf(rowNum)));
    Assert.assertTrue(tablePage.getTableRowData(rowNum).get(1).equalsIgnoreCase("Table cell"));
    Assert.assertTrue(tablePage.getTableRowData(rowNum).get(5).equalsIgnoreCase("Table cell"));
  }
}
