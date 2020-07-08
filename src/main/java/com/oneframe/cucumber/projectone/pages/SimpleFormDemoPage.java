package com.oneframe.cucumber.projectone.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneframe.cucumber.oneframe.utils.WebDriverFactory;

public class SimpleFormDemoPage {

    public SimpleFormDemoPage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Input Forms')]")
    private WebElement tabInputForms;

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

    @FindBy(xpath = "//button[contains(text(),'Show Message')]")
    private WebElement buttonShowMessage;

    @FindBy(xpath = "//label[contains(text(),'Your Message:')]/following-sibling::span")
    private WebElement labelGetShowMessageOutput;

    public void acceptAnAlert() {
        WebDriverFactory.waitForAnElementToBeVisible(acceptAnAlert, 10);
        WebDriverFactory.clickWebElement(acceptAnAlert);
    }

    public void clickonTab(String tabString) {
        WebDriverFactory.clickWebElement(tabInputForms);
    }

    /**
     * Click on subtab.
     *
     * @param subTabString
     *            - sub tab name.
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
     * @param arg
     *            - text to be entered into message textbox.
     * @author sudheer.singh
     */
    public void enterTextIntoMessageBox(String arg) {
        WebDriverFactory.sendKeys(txtBoxEnterMessage, arg);
    }

    /**
     * Click show message button.
     *
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
        WebDriverFactory.waitForAnElementToBeVisible(labelGetShowMessageOutput, 4);
        return labelGetShowMessageOutput.getText();
    }
}
