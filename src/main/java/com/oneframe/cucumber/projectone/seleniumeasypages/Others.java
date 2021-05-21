package com.oneframe.cucumber.projectone.seleniumeasypages;

import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Others {

  public Others() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  @FindBy(xpath = "//a[contains(text(),'Drag and Drop')]")
  private WebElement subTabDragAndDrop;

  @FindBy(xpath = "//div[@class='panel-body']/div[@class='w50 moveleft']/div[@id='mydropzone']")
  private WebElement targetDropedAt;

  /**
   * Click on subtab.
   *
   * @param subTabString - sub tab name.
   * @author sudheer.singh
   */
  public void clickOnSubtab(String subTabString) {
    if (subTabString.equalsIgnoreCase("Drag and Drop")) {
      WebDriverFactory.clickWebElement(subTabDragAndDrop);
    }
  }

  /**
   * Drag draggable item from source to destinations.
   *
   * @param str - name of the draggable item.
   */
  public void dragItemIntoTargetBox(String str) {
    String xpath = "//div[@id='todrag']/span[contains(text(),'STR')]";
    String finalXpath = xpath.replace("STR", str);
    WebElement sourcElement = WebDriverFactory.getDriver().findElement(By.xpath(finalXpath));
    Actions actions = new Actions(WebDriverFactory.getDriver());
    actions.dragAndDrop(sourcElement, targetDropedAt).perform();
    actions.clickAndHold().dragAndDrop(sourcElement, targetDropedAt).perform();
  }
}
