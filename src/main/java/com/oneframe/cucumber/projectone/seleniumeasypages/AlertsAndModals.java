package com.oneframe.cucumber.projectone.seleniumeasypages;

import com.oneframe.cucumber.oneframebase.utils.LogPrinter;
import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsAndModals {

  public AlertsAndModals() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//a[contains(text(),'Bootstrap Alerts')]")
  private WebElement subTabBootstrapAlets;

  @FindBy(xpath = "//a[contains(text(),'Bootstrap Modals')]")
  private WebElement subTabBootstrapModals;

  @FindBy(xpath = "//a[contains(text(),'Javascript Alerts')]")
  private WebElement subTabJavaScriptAlerts;

  @FindBy(xpath = "//button[@id='autoclosable-btn-success']")
  private WebElement btnAutocloseablesuccess;

  @FindBy(xpath = "//button[@id='normal-btn-success']")
  private WebElement btnNormalsuccess;

  @FindBy(xpath = "normal-btn-info")
  private WebElement btnNormalinfo;

  @FindBy(xpath = "//div[@class='alert alert-info alert-normal-info']/button")
  private WebElement btNormalinfoAlertClose;

  @FindBy(xpath = "//div[@class='alert alert-success alert-autocloseable-success']")
  private WebElement messageAutocloseablesuccess;

  @FindBy(xpath = "//div[@class='alert alert-success alert-normal-success']/button")
  private WebElement messageNormalsuccess;

  @FindBy(xpath = "//div[@class='alert alert-info alert-normal-info']")
  private WebElement messageNormalinfo;

  @FindBy(xpath = "//div[contains(text(),'Single Modal Example')]/following-sibling::"
      + "div/a[@class='btn btn-primary']")
  private WebElement btnSingleModeExampleLaunchModel;

  @FindBy(xpath = "//div[contains(text(),'Multiple Modal Example')]/following-sibling::"
      + "div/a[@class='btn btn-primary']")
  private WebElement btnMultipleModeExampleLaunchModel;

  @FindBy(xpath = "//div[@class='modal-header']/button")
  private WebElement popUpsingleMode;

  @FindBy(xpath = "//div[@class='modal-header']/button[@xpath='1']")
  private WebElement popUpMultipleMode;

  @FindBy(xpath = "//div[contains(text(),'Java Script Alert Box')]/following-sibling::"
      + "div/button[@class='btn btn-default']")
  private WebElement alertJavaScript1;

  @FindBy(xpath = "//b[contains(text(),'Click the button to display an confirm box:')]/"
      + "following-sibling::button")
  private WebElement alertJavaScript2;

  @FindBy(xpath = "//div[contains(text(),'Java Script Alert Box')]/following-sibling::div/"
      + "button[@class='btn btn-default btn-lg']")
  private WebElement alertJavaScript3;

  /**
   * Click on sub tab of Alerts and Model tab.
   *
   * @param subTabName - sub tab name
   */
  public void clickOnSubTab(String subTabName) {
    switch (subTabName) {
      case "Bootstrap Alerts":
        WebDriverFactory.clickWebElement(subTabBootstrapAlets);
        break;
      case "Bootstrap Modals":
        WebDriverFactory.clickWebElement(subTabBootstrapModals);
        break;
      case "Javascript Alerts":
        WebDriverFactory.clickWebElement(subTabJavaScriptAlerts);
        break;
      default:
        LogPrinter.printLog("Wrong Sub tab name is provided.");
    }
  }

  /**
   * Click on the alerts button.
   *
   * @param buttonName - name of the button.
   */
  public void clickOnBootStrapbutton(String buttonName) {
    switch (buttonName) {
      case "Autocloseable success":
        WebDriverFactory.clickWebElement(btnAutocloseablesuccess);
        break;
      case "Normal success":
        WebDriverFactory.clickWebElement(btnNormalsuccess);
        break;
      case "Normal Info":
        WebDriverFactory.clickWebElement(btnNormalinfo);
        break;
      default:
        LogPrinter.printLog("Wrong button name is provided.");
    }
  }

  /**
   * Get message displayed after clicking alerts button.
   *
   * @param buttonName - name of the alert button.
   * @return - Message displayed after clicking alert button.
   */
  public String getMessage(String buttonName) {
    switch (buttonName) {
      case "Autocloseable success":
        return messageAutocloseablesuccess.getText();
      case "Normal success":
        return messageNormalsuccess.getAttribute("innerText");
      case "Normal Info":
        return messageNormalinfo.getText();
      default:
        LogPrinter.printLog("Wrong button name whose text to be fetched is provided.");
    }
    return null;
  }

  /**
   * close normal info alerts.
   */
  public void closeNormalInfoAlerts() {
    btNormalinfoAlertClose.click();
  }

  /**
   * Click on the launch model button.
   *
   * @param buttonName - could be either single mode or multiple mode.
   */
  public void clickLaunchButton(String buttonName) {
    if (buttonName.equalsIgnoreCase("Single Mode")) {
      btnSingleModeExampleLaunchModel.click();
    } else if (buttonName.equalsIgnoreCase("Multiple Mode")) {
      btnMultipleModeExampleLaunchModel.click();
    }
  }

  /**
   * Verify that is Single modal pop up is opened or not.
   *
   * @return - true is single modal pop up is displayed else false.
   */
  public boolean isSingleModelExamplePopUpDisplayed() {
    return WebDriverFactory.isElementVisible(popUpsingleMode, 10);
  }

  /**
   * Verify that is Single modal pop up is opened or not.
   *
   * @return - true is single modal pop up is displayed else false.
   */
  public boolean isMultipleModelExamplePopUpDisplayed() {
    return WebDriverFactory.isElementVisible(popUpMultipleMode, 10);
  }

  /**
   * Close Single Mode Pop Up.
   */
  public void closeSingleModePopUp(String popUpName) {
    if (popUpName.equalsIgnoreCase("Single")) {
      popUpsingleMode.click();
    } else {
      popUpMultipleMode.click();
    }
  }

  /**
   * Click on java script alert box button.
   *
   * @param jsAlertName - alert name.
   */
  public void clickJavaScriptAlert(String jsAlertName) {
    if (jsAlertName.equalsIgnoreCase("alertJavaScript1")) {
      WebDriverFactory.clickWebElement(alertJavaScript1);
    } else if (jsAlertName.equalsIgnoreCase("alertJavaScript2")) {
      WebDriverFactory.clickWebElement(alertJavaScript2);
    } else {
      WebDriverFactory.clickWebElement(alertJavaScript3);
    }
  }

  /**
   * Get alert title.
   *
   * @return - title of an alert.
   */
  public String getAlertName() {
    return WebDriverFactory.getDriver().switchTo().alert().getText();
  }

  /**
   * Close the alert.
   */
  public void closeAlert() {
    WebDriverFactory.getDriver().switchTo().alert().accept();
  }

  /**
   * Enter text into alert pop up box and then close the pop up.
   */
  public void enterTextIntoAlertBoxAndCloseTheAalert() {
    WebDriverFactory.getDriver().switchTo().alert().sendKeys("Sample Text");
    WebDriverFactory.getDriver().switchTo().alert().accept();
  }
}
