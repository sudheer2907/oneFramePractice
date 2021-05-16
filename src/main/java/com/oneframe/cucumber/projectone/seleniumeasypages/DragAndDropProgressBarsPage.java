package com.oneframe.cucumber.projectone.seleniumeasypages;

import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropProgressBarsPage {

  public DragAndDropProgressBarsPage() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//a[contains(text(),'Drag & Drop Sliders')]")
  private WebElement subTabDragAndDropSliders;

  @FindBy(xpath = "//div[@id='slider1']/div/input")
  private WebElement sliderGrey;

  /**
   * Click on the sub tab of progress bars tab.
   *
   * @param subTabName - name of the sub tab.
   * @author Sudheer.Singh@
   */
  public void clickOnSubTab(String subTabName) {
    switch (subTabName) {
      case "Drag & Drop":
        WebDriverFactory.clickWebElement(subTabDragAndDropSliders);
        break;
      default:
        Assert.fail("Wrong Sub tab name is provided.");
    }
  }

  /**
   * Move grey slider pointer.
   *
   * @param value - value tp be slide.
   * @throws InterruptedException - if in case of interrupted exceptions.
   */
  public void moveGreySlider(int value) throws InterruptedException {
    WebDriverFactory.waitForAnElementToBeVisible(sliderGrey, 10);
    Actions move = new Actions(WebDriverFactory.getDriver());
    move.dragAndDropBy(sliderGrey, value, 0).release().perform();
    TimeUnit.SECONDS.sleep(5);
  }

  /**
   * Get First Slide value.
   *
   * @author sudheer.singh
   */
  public String getFirstSliderValue() {
    return sliderGrey.getText();
  }
}
