package com.oneframe.cucumber.projectone.seleniumeasypages;

import com.oneframe.cucumber.oneframebase.utils.LogPrinter;
import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;
import edu.emory.mathcs.backport.java.util.LinkedList;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePage {

  public TablePage() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//a[contains(text(),'Table Pagination')]")
  private WebElement subTabTablePagination;

  @FindBy(xpath = "//a[contains(text(),'Table Data Search')]")
  private WebElement subTabTableDataSearch;

  @FindBy(xpath = "//input[@id='task-table-filter']")
  private WebElement txtBoxFilterBySearchTextboxElement;

  /**
   * Click on the tab Table then click on the sub tab.
   *
   * @param subTabName - name of the sub-tab available inside table tab.
   */
  public void clickOnSubTab(String subTabName) {
    switch (subTabName) {
      case "Table Pagination":
        WebDriverFactory.clickWebElement(subTabTablePagination);
        break;
      case "Table Data Search":
        WebDriverFactory.clickWebElement(subTabTableDataSearch);
        break;
      default:
        LogPrinter.printLog("Wrong Sub tab name is provided.");
    }
  }

  /**
   * Return true if table pagination page gets loaded else false.
   *
   * @return - true if pagination page is loaded else false
   */
  public boolean isTablePaginationPageLoaded() {
    return WebDriverFactory.getDriver()
        .findElement(By.xpath("//thead[@class='btn-primary']"))
        .isDisplayed();
  }

  /**
   * Get the total number of rows available inside a table.
   *
   * @return - row size.
   */
  public int getTableRowSize() {
    List<WebElement> rows =
        WebDriverFactory.getDriver()
            .findElements(By.xpath("//tbody[@id='myTable']/tr[@style='display: table-row;']"));
    return rows.size();
  }

  /** Get list of table IDs. */
  public List<Integer> getListOfIds() {
    int rowSize = getTableRowSize();
    List<Integer> listOfId = new ArrayList<>();
    for (int i = 1; i <= rowSize; i++) {
      listOfId.add(
          Integer.parseInt(
              WebDriverFactory.getDriver()
                  .findElement(
                      By.xpath(
                          "//tbody[@id='myTable']/tr[@style='display: table-row;'][" + i + "]/td"))
                  .getText()));
    }
    return listOfId;
  }

  /**
   * Get tble row data.
   *
   * @param rowNum - row number whose data to be fetched.
   * @return - rows data
   */
  public List<String> getTableRowDataTablePaginationPage(int rowNum) {
    List<String> tableRowData = new LinkedList();
    for (int i = 1; i < 7; i++) {
      String textFetched =
          WebDriverFactory.getDriver()
              .findElement(
                  By.xpath(
                      "//tbody[@id='myTable']/tr[@style='display: table-row;']["
                          + rowNum
                          + "]/td["
                          + i
                          + "]"))
              .getText();
      tableRowData.add(textFetched);
    }
    return tableRowData;
  }

  /**
   * Enter some text to be searched into Filter by task search box.
   *
   * @param dataToBeSeached - data to be searched.
   * @author Sudheer.Singh
   */
  public void enterTextIntoSearchboxTextBox(String dataToBeSeached) {
    WebDriverFactory.sendKeys(txtBoxFilterBySearchTextboxElement, dataToBeSeached);
  }

}
