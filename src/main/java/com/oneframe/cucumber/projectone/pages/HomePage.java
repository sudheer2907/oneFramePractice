package com.oneframe.cucumber.projectone.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneframe.cucumber.oneframe.utils.WebDriverFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Input Forms')]")
    private WebElement tabInputForms;

    @FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Progress Bars')]")
    private WebElement tabProgressBars;

    /**
     * Click on tab.
     *
     * @param tabString
     *            - tab name.
     * @author sudheer.singh
     */
    public void clickonTab(String tabString) {
        System.out.println("tabString is " + tabString);
        switch (tabString) {
        case "Input Forms":
            WebDriverFactory.clickWebElement(tabInputForms);
            break;
        case "Progress Bars":
            WebDriverFactory.clickWebElement(tabProgressBars);
            break;
        default:
            Assert.fail("Wrong Sub tab name is provided.");
        }
    }
}
