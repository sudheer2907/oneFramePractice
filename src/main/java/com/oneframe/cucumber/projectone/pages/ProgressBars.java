package com.oneframe.cucumber.projectone.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneframe.cucumber.oneframe.utils.WebDriverFactory;

public class ProgressBars {

    public ProgressBars() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'JQuery Download Progress bars')]")
    private WebElement subTabJQueryDownloadProgressbars;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Progress bar')]")
    private WebElement subTabBootstrapProgressbar;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Drag & Drop Sliders')]")
    private WebElement subTabDragAndDropSliders;

    /**
     * Click on subtab.
     *
     * @param subTabString
     *            - sub tab name.
     * @author sudheer.singh
     */
    public void clickOnSubtab(String subTabString) {
        switch (subTabString) {
        case "JQuery Download Progress bars":
            WebDriverFactory.clickWebElement(subTabJQueryDownloadProgressbars);
            break;

        case "Bootstrap Progress bar":
            WebDriverFactory.clickWebElement(subTabBootstrapProgressbar);
            break;

        case "Drag & Drop Sliders":
            WebDriverFactory.clickWebElement(subTabDragAndDropSliders);
            break;

        default:
            Assert.fail("Wrong Sub tab name is provided.");
        }
    }
}
