package com.oneframe.cucumber.projectone.seleniumeasypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;

public class DragAndDropProgressBarsPage {

  public DragAndDropProgressBarsPage() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//div[@class='range']/input[@name='range']")
  private WebElement sliderFisrtSlider;

  @FindBy(xpath = "//div[@class='range']//input[@name='range']/following-sibling::output")
  private WebElement sliderFisrtSliderValue;

  /**
   * Move 1st slider to the given value.
   *
   * @param value - value to be slide.
   * @throws InterruptedException - if in case of interrupted exception.
   * @author sudheer.singh
   */
  public void moveFirstSlider(int value) throws InterruptedException {
    WebDriverFactory.waitForPageToLoad(30);
    /*
     * new Actions(WebDriverFactory.getDriver()).dragAndDropBy( sliderFisrtSlider, value,
     * 0).build().perform();
     */
    Actions builder = new Actions(WebDriverFactory.getDriver());

    Action dragAndDrop;

    int height = sliderFisrtSlider.getSize().getHeight();
    int width = sliderFisrtSlider.getSize().getWidth();

    if (width > height) {
      // high likely a horizontal slider
      dragAndDrop = builder.clickAndHold(sliderFisrtSlider).moveByOffset(-(width / 2), 0)
          .moveByOffset((int) ((width / 100) * value), 0).release().build();
    } else {
      // high likely a vertical slider
      dragAndDrop = builder.clickAndHold(sliderFisrtSlider).moveByOffset(0, -(height / 2))
          .moveByOffset(0, (int) ((height / 100) * value)).release().build();
    }
    dragAndDrop.perform();
    Thread.sleep(10000);

  }

  /**
   * Get First Slide value.
   *
   * @author sudheer.singh
   */
  public String getFirstSliderValue() {
    System.out.println(sliderFisrtSliderValue.getText());
    return sliderFisrtSliderValue.getText();
  }
}
