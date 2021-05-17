package com.oneframe.cucumber.projectone.seleniumeasypages;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;

public class ListBox {

  public ListBox() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//a[contains(text(),'Bootstrap List Box')]")
  private WebElement subTabBootstrapListBox;

  @FindBy(xpath = "//a[contains(text(),'JQuery List Box')]")
  private WebElement subTabJuqeryListBox;

  @FindBy(xpath = "//a[contains(text(),'Data List Filter')]")
  private WebElement subTabDataListFilter;

  @FindBy(xpath = "//span[contains(@class,'right')]")
  private WebElement btnRightButton;

  @FindBy(xpath = "//span[contains(@class,'left')]")
  private WebElement btnLeftButton;
  
  @FindBy(xpath = "//div[contains(@class,'list-right')]/descendant::div/input")
  private WebElement txtboxSearchIntoRightSearchBar;

  /**
   * Click on subtab.
   *
   * @param subTabString - sub tab name.
   * @author sudheer.singh
   */
  public void clickOnSubtab(String subTabString) {
    switch (subTabString) {
      case "Bootstrap List Box":
        WebDriverFactory.clickWebElement(subTabBootstrapListBox);
        break;

      case "JQuery List Box":
        WebDriverFactory.clickWebElement(subTabJuqeryListBox);
        break;

      case "Data List Filter":
        WebDriverFactory.clickWebElement(subTabDataListFilter);
        break;

      default:
        Assert.fail("Wrong Sub tab name is provided.");
    }
  }

  /**
   * Select options form left side list box.
   *
   * @param options - options to be selected from the left list.
   * @author sudheer.singh
   */
  public void selectOptionFromLeftList(String options) {
    String mainXpathString = "//ul[@class='list-group']/li[contains(text(),'STR')]";
    WebDriverFactory.getDriver().findElement(By.xpath(mainXpathString.replace("STR", options)))
        .click();
  }

  /**
   * Click left/right arrow button.
   *
   * @param arrowName - Right or Left
   */
  public void clickArrowButton(String arrowName) {
    if (arrowName.equalsIgnoreCase("Right")) {
      WebDriverFactory.clickWebElement(btnRightButton);
    } else {
      WebDriverFactory.clickWebElement(btnLeftButton);
    }
  }

  /**
   * Get list of all the options from right list.
   */
  public List<String> getRightSideOpionsOfList() {
    String mainXpathString = "//div[contains(@class,'right')]/div/ul[@class='list-group']/li";
    int listSize = WebDriverFactory.getDriver().findElements(By.xpath(mainXpathString)).size();
    List<String> list = new LinkedList<>();
    for (int j = 1; j <= listSize; j++) {
      list.add(WebDriverFactory.getDriver().findElement(By.xpath(mainXpathString + "[" + j + "]"))
          .getText());
    }
    return list;
  }

  /**
   * Search into right side.
   *
   * @param input - text to be searched.
   * @author Sudheer.Singh
   */
  public void searchIntoRightSide(String input) {
    txtboxSearchIntoRightSearchBar.clear();
    WebDriverFactory.sendKeys(txtboxSearchIntoRightSearchBar, input);
  }

  /**
   * Get list of all the options from right list.
   */
  public String getFirstOptionsFromRightSideOpions() {
    return WebDriverFactory.getDriver().findElement(By.xpath(
        "//div[contains(@class,'right')]/div/ul[@class='list-group']/li[@class='list-group-item active']"))
        .getText();
  }

  /**
   * Select multiple dropdown option from a JQuery list box.
   *
   * @param selectList - list of the options which has to be selected.
   * @throws InterruptedException - if in case of interrupted exceptions.
   */
  public void selectMulitpleOptionFromJqueryListBox(List<String> selectList) {
    for (String string : selectList) {
      new Select(WebDriverFactory.getDriver()
          .findElement(By.xpath("//select[@class='form-control pickListSelect pickData']")))
              .selectByVisibleText(string);
    }
  }

  /**
   * Click button on the JQuery Dual List Box Demo page.
   *
   * @param buttonName - name of button to be clicked.
   */
  public void clickButton(String buttonName) {
    String xpathString = "//button[text()='" + buttonName + "']";
    WebDriverFactory.getDriver().findElement(By.xpath(xpathString)).click();
  }

  /**
   * Get list of selected JQuery list.
   *
   * @return - list of selected JQuery Options
   */
  public List<String> getListOfJqueryselectedList() {
    String mainXpathString = "//select[@class='form-control pickListSelect pickListResult']/option";
    int listSize = WebDriverFactory.getDriver().findElements(By.xpath(mainXpathString)).size();
    List<String> list = new LinkedList<>();
    for (int j = 1; j <= listSize; j++) {
      list.add(WebDriverFactory.getDriver().findElement(By.xpath(mainXpathString + "[" + j + "]"))
          .getText());
    }
    return list;
  }
}
