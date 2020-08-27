package com.oneframe.cucumber.projectone.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneframe.cucumber.oneframebase.utils.LogPrinter;
import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;

public class SimpleFormDemoPage {

  public SimpleFormDemoPage() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Simple Form Demo')]")
  private WebElement subTabSimpleFormDemo;

  @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Checkbox Demo')]")
  private WebElement subTabCheckBoxDemo;

  @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Radio Buttons Demo')]")
  private WebElement subTabRadioButtonDemo;

  @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Select Dropdown List')]")
  private WebElement subTabSelectDropDownList;

  @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Input Form Submit')]")
  private WebElement subTabInputFormSubmit;

  @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Ajax Form Submit')]")
  private WebElement subTabAjaxFormSubmit;

  @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'JQuery Select dropdown')]")
  private WebElement subTabJQuerySelectDropdown;

  @FindBy(xpath = "//a[@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']")
  private WebElement acceptAnAlert;

  @FindBy(xpath = "//input[@id='user-message']")
  private WebElement txtBoxEnterMessage;

  @FindBy(xpath = "//input[@id='sum1']")
  private WebElement txtBoxEnterAMessage;

  @FindBy(xpath = "//input[@id='sum2']")
  private WebElement txtBoxEnterBMessage;

  @FindBy(xpath = "//button[contains(text(),'Show Message')]")
  private WebElement buttonShowMessage;

  @FindBy(xpath = "//span[@id='display']")
  private WebElement labelGetShowMessageOutput;

  @FindBy(xpath = "//button[contains(text(),'Get Total')]")
  private WebElement btnGetTotalOutput;

  @FindBy(xpath = "//span[@id='displayvalue']")
  private WebElement labelGetTotalOutput;

  @FindBy(xpath = "//input[@id='isAgeSelected']")
  private WebElement chkBoxClickOnThisChkBox;

  @FindBy(xpath = "//div[@id='txtAge']")
  private WebElement labelTextClickOnThisChkBox;

  @FindBy(xpath = "//button[@id='buttoncheck']")
  private WebElement btnGetValues;

  @FindBy(xpath = "//p[@class='radiobutton']")
  private WebElement labelTextGetValuesResult;

  @FindBy(xpath = "//div[@class='panel-body']/preceding-sibling::"
      + "div[text()='Radio Button Demo']/following-sibling::div")
  private WebElement radioBtnGenderRadioButtonDemoXpath;

  public void acceptAnAlert() {
    WebDriverFactory.waitForAnElementToBeVisible(acceptAnAlert, 20);
    WebDriverFactory.clickWebElement(acceptAnAlert);
  }

  /**
   * Click on subtab.
   *
   * @param subTabString - sub tab name.
   * @author sudheer.singh
   */
  public void clickOnSubtab(String subTabString) {
    switch (subTabString) {
      case "Simple Form Demo":
        WebDriverFactory.clickWebElement(subTabSimpleFormDemo);
        break;
      case "Checkbox Demo":
        WebDriverFactory.clickWebElement(subTabCheckBoxDemo);
        break;
      case "Radio Buttons Demo":
        WebDriverFactory.clickWebElement(subTabRadioButtonDemo);
        break;
      case "Select Dropdown List":
        WebDriverFactory.clickWebElement(subTabSelectDropDownList);
        break;
      case "Input Form Submit":
        WebDriverFactory.clickWebElement(subTabInputFormSubmit);
        break;
      case "Ajax Form Submit":
        WebDriverFactory.clickWebElement(subTabAjaxFormSubmit);
        break;
      case "JQuery Select dropdown":
        WebDriverFactory.clickWebElement(subTabJQuerySelectDropdown);
        break;
      default:
        Assert.fail("Wrong Sub tab name is provided.");
    }
  }

  /**
   * Enter any text into Enter message textbox.
   *
   * @param arg - text to be entered into message textbox.
   * @author sudheer.singh
   */
  public void enterTextIntoEnterMessageTextBox(String arg) {
    WebDriverFactory.sendKeys(txtBoxEnterMessage, arg);
  }

  public void enterTextIntoEnterATextBox(String arg) {
    WebDriverFactory.sendKeys(txtBoxEnterAMessage, arg);
  }

  public void enterTextIntoEnterBTextBox(String arg) {
    WebDriverFactory.sendKeys(txtBoxEnterBMessage, arg);
  }

  /**
   * Click show message button.
   *
   * @throws Exception - exception if any occured.
   * @author sudheer.singh
   */
  public void clickShowMessageButton() {
    WebDriverFactory.clickWebElement(buttonShowMessage);
  }

  /**
   * Get text message entered into the enter message text box.
   *
   * @author sudheer.singh
   */
  public String getTextShowMessage() {
    WebDriverFactory.waitForAnElementToBeVisible(labelGetShowMessageOutput, 10);
    return labelGetShowMessageOutput.getText();
  }

  public void clickGetTotalValue() {
    WebDriverFactory.clickWebElement(btnGetTotalOutput);
  }

  public String getTotalValueText() {
    return labelGetTotalOutput.getText();
  }

  public void clickClickOnthIsCheckBox() {
    WebDriverFactory.clickWebElement(chkBoxClickOnThisChkBox);
  }

  /**
   * Get message displayed after clicking the checkbox.
   *
   * @return - checkbox message after selecting that.
   * @author sudheer.singh
   */
  public String getCheckBoxSelectedMessage() {
    if (chkBoxClickOnThisChkBox.isSelected()) {
      LogPrinter.printLog("Selected");
    }
    return labelTextClickOnThisChkBox.getText();
  }

  /**
   * Click on male/female radio button under radio button demo.
   *
   * @param gender - Male or Female
   */
  public void selectGenderUnderRadioButtonDemo(String gender) {
    WebDriverFactory.clickWebElement(radioBtnGenderRadioButtonDemoXpath
        .findElement(By.xpath(".//label[contains(text(),'" + gender + "')]/input[1]")));
  }

  /**
   * Click on male/female radio button under Group Radio button demo.
   *
   * @param gender - Male or Female
   */
  public void selectGenderUnderGroupRadioButtonDemo(String gender) {
    LogPrinter.printLog("To be completed " + gender);
  }

  public void clickGetValueButton() {
    WebDriverFactory.clickWebElement(btnGetValues);
  }

  public String getResultAfterClickingGetCheckedValues() {
    WebDriverFactory.waitForAnElementToBeVisible(labelTextGetValuesResult, 10);
    return labelTextGetValuesResult.getText();
  }
}
